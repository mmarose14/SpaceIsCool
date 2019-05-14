package com.spaceiscool.service

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiManager {

    private const val SERVER_HOST = "https://api.nasa.gov"
    const val API_KEY = "xPX3uoRAmKBdqyX5jMDK81lAycdpZfSJGSFgvUVa"

    private var apiService: WebService

    init {
        val retrofit = initRetrofit()
        apiService = retrofit.create(WebService::class.java)
    }

    private fun initRetrofit(): Retrofit {

        return Retrofit.Builder()
                .baseUrl(SERVER_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
    }

    fun getDataService(): WebService {
        return apiService
    }

}