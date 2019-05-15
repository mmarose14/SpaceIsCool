package com.spaceiscool.marsphotos

import com.spaceiscool.base.BaseView
import com.spaceiscool.data.MarsPhotosData

interface MarsPhotosContract {
    interface Presenter {
    }

    interface View: BaseView {
        fun displayMarsPhotos(photos: List<MarsPhotosData.Photo>)
        fun displayProgressBar()
        fun removeProgressBar()
    }
}