package com.spaceiscool.pictureoftheday

import com.spaceiscool.base.BaseView
import com.spaceiscool.data.APOD

interface APODContract {
    interface Presenter {
        fun getPhotoOfTheDay()
    }

    interface View: BaseView {
        fun displayProgressBar()
        fun removeProgressBar()
        fun showAPOD(apod: APOD)
    }
}