package com.spaceiscool.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseActivity: AppCompatActivity() {

    fun displayFragment(layout: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(layout, fragment)
            .commit()
    }
}