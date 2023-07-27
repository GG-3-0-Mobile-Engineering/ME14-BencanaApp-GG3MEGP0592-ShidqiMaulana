package com.example.finalprojectgigih.core.data.source.local.room
//
//import android.content.Context
//import android.util.Log
//import androidx.room.RoomDatabase
//import androidx.sqlite.db.SupportSQLiteDatabase
//import com.example.finalprojectgigih.core.R
//import com.example.finalprojectgigih.core.data.MainRepository
//import com.example.finalprojectgigih.core.data.source.local.entity.AreaCodeEntity
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import org.json.JSONArray
//import org.json.JSONException
//import java.io.BufferedReader
//
//class PrefillData(private val context: Context, private val mainRepository: MainRepository) : RoomDatabase.Callback() {
//    override fun onCreate(db: SupportSQLiteDatabase) {
//        super.onCreate(db)
//        CoroutineScope(Dispatchers.IO).launch {
//            fillWithStartingData(context, mainRepository)
//        }
//    }
//
//    private suspend fun fillWithStartingData(context: Context, mainRepository: MainRepository) {
//        try {
//            val data = loadItemArray(context)
//            if (data != null) {
//                for (i in 0 until data.length()) {
//                    val item = data.getJSONObject(i)
//                    val itemArea = item.getString("item")
//                    val areaCodeEntity = AreaCodeEntity(itemArea)
//                    mainRepository.insertAreaCode(areaCodeEntity)
//                }
//            }
//        }
//        catch (e: JSONException) {
//            Log.e("Prefill Exc", "fillWithStartingData: $e")
//        }
//    }
//
//    private fun loadItemArray(context: Context): JSONArray {
//        val inputStream = context.resources.openRawResource(R.raw.area_code)
//        BufferedReader(inputStream.reader()).use {
//            return JSONArray(it.readText())
//        }
//    }
//
//}