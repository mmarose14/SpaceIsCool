package com.spaceiscool.pictureoftheday

import android.os.Bundle
import com.spaceiscool.R
import com.spaceiscool.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class APODActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apod)

        displayFragment(R.id.fragment_layout, APODFragment())
    }
}
