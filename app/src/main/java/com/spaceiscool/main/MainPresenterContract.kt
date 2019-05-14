package com.spaceiscool.main

import com.spaceiscool.data.NearEarthObjectFull

interface MainPresenterContract {
    interface Presenter {

    }

    interface View {
        fun displayError()
        fun displayNEOs(near_earth_objects: List<NearEarthObjectFull.NearEarthObject>)

    }
}
