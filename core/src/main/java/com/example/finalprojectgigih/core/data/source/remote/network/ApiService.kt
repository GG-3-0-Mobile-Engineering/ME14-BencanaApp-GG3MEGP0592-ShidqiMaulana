package com.example.finalprojectgigih.core.data.source.remote.network

import com.example.finalprojectgigih.core.data.source.remote.response.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("https://data.petabencana.id/reports?timeperiod=604800")
    suspend fun getReportsArchive(): Response

}