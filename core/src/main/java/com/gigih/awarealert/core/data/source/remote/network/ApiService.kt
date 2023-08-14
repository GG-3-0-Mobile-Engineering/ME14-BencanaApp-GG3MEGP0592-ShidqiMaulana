package com.gigih.awarealert.core.data.source.remote.network

import com.gigih.awarealert.core.data.source.remote.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("reports")
    suspend fun getAllReportsArchive(
        @Query("timeperiod") time: String = "604800"
    ): Response

    @GET("reports")
    suspend fun getSearchedReportsArchive(
        @Query("admin") areaCode: String,
        @Query("timeperiod") time: String = "604800"
    ): Response

}