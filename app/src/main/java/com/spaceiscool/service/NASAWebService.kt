package com.spaceiscool.service

import com.spaceiscool.data.MarsPhotosData
import com.spaceiscool.data.NEOResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NASAWebService {
    @GET("neo/rest/v1/neo/browse")
    fun getNEOs(@Query("api_key") apiKey: String): Call<NEOResponse>

    @GET("mars-photos/api/v1/rovers/curiosity/photos")
    fun getMarsPhotos(@Query("api_key") apiKey: String, @Query("sol") sol: String = "1000"): Call<MarsPhotosData>
}