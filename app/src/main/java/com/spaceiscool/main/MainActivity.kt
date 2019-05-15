package com.spaceiscool.main

import android.os.Bundle
import com.spaceiscool.R
import com.spaceiscool.base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayFragment(R.id.fragment_layout, MainFragment())
    }
}
