package com.spaceiscool.service

import com.spaceiscool.data.APOD
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NASAWebService {
    @GET("planetary/apod")
    fun getAPOD(@Query("api_key") apiKey: String): Call<APOD>
}