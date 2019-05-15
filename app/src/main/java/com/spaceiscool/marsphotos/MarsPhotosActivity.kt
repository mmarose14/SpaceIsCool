package com.spaceiscool.marsphotos

import android.os.Bundle
import com.spaceiscool.R
import com.spaceiscool.base.BaseActivity

class MarsPhotosActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mars_photos)

        displayFragment(R.id.fragment_layout, MarsPhotosFragment())
    }
}