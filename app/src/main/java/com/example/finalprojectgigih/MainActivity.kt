package com.example.finalprojectgigih

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalprojectgigih.core.data.Resource
import com.example.finalprojectgigih.core.ui.MainAdapter
import com.example.finalprojectgigih.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter
    private lateinit var areaAdapter: ArrayAdapter<String>
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        mainAdapter = MainAdapter()
        mainAdapter.onItemClick = { selectedData ->
            val marker = LatLng(
                selectedData.coordinates?.get(1) ?: 0.0,
                selectedData.coordinates?.get(0) ?: 0.0
            )
            mMap.animateCamera(CameraUpdateFactory.newLatLng(marker))
        }

        with(binding.rvMain) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
        }

        areaAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line, mainViewModel.areaNameList
        )

        binding.actSearch.setAdapter(areaAdapter)
        binding.actSearch.setOnEditorActionListener { textView, actionId, _ ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                val areaCode =
                    mainViewModel.searchAreaCode(textView.text.toString())
                if (areaCode.isNotEmpty()) observeData(areaCode)
                else Toast.makeText(this@MainActivity, "Area data not found", Toast.LENGTH_SHORT)
                    .show()
                handled = true
            }
            handled
        }
    }

    private fun observeData(areaCode: String = "") {
        mainViewModel.getReportList(areaCode).observe(this) { reportList ->
            if (reportList != null) {
                when (reportList) {
                    is Resource.Loading -> {
                        stateLoading()
                    }

                    is Resource.Success -> {
                        stateSuccess(reportList.data?.isEmpty() == true)
                        mainViewModel.reportList.value = reportList.data
                        mainAdapter.setData(reportList.data)
                        populateMap()
                    }

                    is Resource.Error -> {
                        stateError()
                    }
                }
            }
        }
    }

    private fun stateLoading() {
        with(binding) {
            progressBar.root.visibility = View.VISIBLE
            tvEmpty.visibility = View.GONE
            errorWarning.root.visibility = View.GONE
        }
    }

    private fun stateSuccess(empty: Boolean) {
        with(binding) {
            progressBar.root.visibility = View.GONE
            errorWarning.root.visibility = View.GONE
            tvEmpty.visibility = if (empty) View.VISIBLE else View.GONE
        }
    }

    private fun stateError() {
        with(binding) {
            progressBar.root.visibility = View.GONE
            tvEmpty.visibility = View.GONE
            errorWarning.root.visibility = View.VISIBLE
            Handler(Looper.getMainLooper()).postDelayed({
                errorWarning.root.visibility = View.GONE
            }, 2000)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
        if (
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.INTERNET
                ),
                200
            )
        }
        mMap.setMinZoomPreference(8.0f)
        mMap.setMaxZoomPreference(16.0f)
//        mMap.isMyLocationEnabled = true

        observeData()
    }

    private fun populateMap() {
        var marker = LatLng(0.0, 0.0)
        var markerColor: Float
        mMap.clear()
        mainViewModel.reportList.value?.forEach {
            marker = LatLng(it.coordinates?.get(1) ?: 0.0, it.coordinates?.get(0) ?: 0.0)
            markerColor = when (it.disasterType) {
                "flood" -> BitmapDescriptorFactory.HUE_AZURE
                "earthquake" -> BitmapDescriptorFactory.HUE_MAGENTA
                "fire" -> BitmapDescriptorFactory.HUE_ROSE
                "haze" -> BitmapDescriptorFactory.HUE_ORANGE
                "wind" -> BitmapDescriptorFactory.HUE_YELLOW
                "volcano" -> BitmapDescriptorFactory.HUE_CYAN
                else -> BitmapDescriptorFactory.HUE_RED
            }
            mMap.addMarker(
                MarkerOptions()
                    .position(marker)
                    .title(it.disasterType)
                    .icon(BitmapDescriptorFactory.defaultMarker(markerColor))
            )
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(marker))

    }

}