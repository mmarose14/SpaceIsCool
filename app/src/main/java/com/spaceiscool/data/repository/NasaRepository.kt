package com.spaceiscool.data.repository

import com.spaceiscool.BuildConfig
import com.spaceiscool.data.api.NASAWebService
import com.spaceiscool.data.model.APOD
import com.spaceiscool.data.model.neo.NEO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NasaRepository @Inject constructor(val nasaWebService: NASAWebService) {

    private val API_KEY = BuildConfig.API_KEY

    val getAPOD: Flow<APOD> = flow {
        val apod = nasaWebService.getAPOD(API_KEY)
        emit(apod)
    }

    val getNEO: Flow<NEO> = flow {
        val neo = nasaWebService.getNEO(API_KEY)
        emit(neo)
    }
}