package com.spaceiscool.service

import com.spaceiscool.data.NEOResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WebService {
    @GET("neo/rest/v1/neo/browse")
    fun getNEOs(@Query("api_key") apiKey: String): Call<NEOResponse>
}