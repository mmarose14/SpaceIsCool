package com.spaceiscool.main

import com.spaceiscool.base.BaseView
import com.spaceiscool.data.NearEarthObjectFull

interface MainPresenterContract {
    interface Presenter {

    }

    interface View: BaseView {
        fun displayNEOs(near_earth_objects: List<NearEarthObjectFull.NearEarthObject>)

    }
}
