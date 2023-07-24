package com.example.finalprojectgigih

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalprojectgigih.core.data.Resource
import com.example.finalprojectgigih.core.ui.MainAdapter
import com.example.finalprojectgigih.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainAdapter = MainAdapter()

        observeData()

        with(binding.rvMain) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
        }
    }

    private fun observeData() {
        mainViewModel.report.observe(this) { report ->
            if (report != null) {
                when (report) {
                    is Resource.Loading -> stateLoading()
                    is Resource.Success -> {
                        stateSuccess(report.data?.isEmpty() == true)
                        mainAdapter.setData(report.data)
                    }

                    is Resource.Error -> stateError()
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

}