package com.spaceiscool.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spaceiscool.data.APOD
import com.spaceiscool.service.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APODViewModel: ViewModel() {
    private var _errorMessage = MutableLiveData<String>()
    val errorMessage get() = _errorMessage

    private var _apod = MutableLiveData<APOD>()
    val apod get() = _apod

    fun getPhotoOfTheDay() {
        ApiManager.getDataService().getAPOD(ApiManager.API_KEY).enqueue(object: Callback<APOD> {
            override fun onFailure(call: Call<APOD>, t: Throwable) {
                _errorMessage.value = t.message
            }

            override fun onResponse(call: Call<APOD>, response: Response<APOD>) {
                response.body()?.let {
                    _apod.value = it
                }
            }

        })
    }
}