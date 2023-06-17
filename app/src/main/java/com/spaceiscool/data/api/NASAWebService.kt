package com.spaceiscool.data.api

import com.spaceiscool.data.model.APOD
import com.spaceiscool.data.model.neo.NEO
import retrofit2.http.GET
import retrofit2.http.Query

interface NASAWebService {
    @GET("planetary/apod")
    suspend fun getAPOD(@Query("api_key") apiKey: String): APOD

    @GET("neo/rest/v1/neo/browse")
    suspend fun getNEO(@Query("api_key") apiKey: String): NEO
}