package com.spaceiscool.service

import com.spaceiscool.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiManager {

    private const val SERVER_HOST = "https://api.nasa.gov"
    const val API_KEY = BuildConfig.API_KEY

    private var apiService: NASAWebService

    init {
        val retrofit = initRetrofit()
        apiService = retrofit.create(NASAWebService::class.java)
    }

    private fun initRetrofit(): Retrofit {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
                .baseUrl(SERVER_HOST)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()
    }

    fun getDataService(): NASAWebService {
        return apiService
    }

}