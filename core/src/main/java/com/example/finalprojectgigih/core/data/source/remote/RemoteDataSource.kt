package com.example.finalprojectgigih.core.data.source.remote

import android.util.Log
import com.example.finalprojectgigih.core.data.source.remote.network.ApiResponse
import com.example.finalprojectgigih.core.data.source.remote.network.ApiService
import com.example.finalprojectgigih.core.data.source.remote.response.GeometriesItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource constructor(private val apiService: ApiService) {

    suspend fun getReports(): Flow<ApiResponse<List<GeometriesItem>>> =
        flow {
            try {
                val response = apiService.getReportsArchive()
                val dataArray = response.result?.objects?.output?.geometries
                if (dataArray != null) {
                    if (dataArray.isNotEmpty()) {
                        emit(ApiResponse.Success(response.result.objects.output.geometries))
                    } else {
                        emit(ApiResponse.Empty)
                    }
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO) as Flow<ApiResponse<List<GeometriesItem>>>

}
