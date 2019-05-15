package com.spaceiscool.marsphotos

import com.spaceiscool.data.MarsPhotosData
import com.spaceiscool.service.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MarsPhotosPresenter(var view: MarsPhotosContract.View) : MarsPhotosContract.Presenter {
    fun getMarsPhotos() {
        view.displayProgressBar()
        ApiManager.getDataService().getMarsPhotos(ApiManager.API_KEY).enqueue(object: Callback<MarsPhotosData> {
            override fun onFailure(call: Call<MarsPhotosData>, t: Throwable) {
                view.removeProgressBar()
                Timber.e(t)
                view.displayError()
            }

            override fun onResponse(call: Call<MarsPhotosData>, response: Response<MarsPhotosData>) {
                view.removeProgressBar()
                Timber.d("Mars Photos Response: %s", response.body())
                response.body()?.photos?.let {
                    view.displayMarsPhotos(it)
                }
            }

        })
    }

}