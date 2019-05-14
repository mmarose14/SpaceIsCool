package com.spaceiscool.main

import com.spaceiscool.data.NEOResponse
import com.spaceiscool.service.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainPresenter(private val view: MainPresenterContract.View) : MainPresenterContract.Presenter {

    fun getNEOBrowse() {
        ApiManager.getDataService().getNEOs(ApiManager.API_KEY).enqueue(object : Callback<NEOResponse> {
            override fun onFailure(call: Call<NEOResponse>, t: Throwable) {
                Timber.e(t)
                view.displayError()

            }

            override fun onResponse(call: Call<NEOResponse>, response: Response<NEOResponse>) {
                Timber.d("NEO Feed: %s", response.body())
                response.body()?.near_earth_objects?.let {
                    view.displayNEOs(it)
                }
            }
        })
    }
}