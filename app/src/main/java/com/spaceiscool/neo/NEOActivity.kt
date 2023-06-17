package com.spaceiscool.neo

import android.os.Bundle
import com.spaceiscool.R
import com.spaceiscool.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NEOActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_neoactivity)

        displayFragment(R.id.fragment_layout, NEOFragment())
    }
}