package com.spaceiscool.pictureoftheday

import com.spaceiscool.data.APOD
import com.spaceiscool.service.ApiManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class APODPresenter(var view: APODContract.View) : APODContract.Presenter {
    override fun getPhotoOfTheDay() {
        view.displayProgressBar()
        ApiManager.getDataService().getAPOD(ApiManager.API_KEY).enqueue(object: Callback<APOD> {
            override fun onFailure(call: Call<APOD>, t: Throwable) {
                view.removeProgressBar()
                view.displayError()
            }

            override fun onResponse(call: Call<APOD>, response: Response<APOD>) {
                view.removeProgressBar()
                response.body()?.let {
                    view.showAPOD(it)
                }
            }

        })
    }

}