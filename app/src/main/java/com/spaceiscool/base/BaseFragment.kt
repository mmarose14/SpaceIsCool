package com.spaceiscool.base

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_mars_photos.*

open class BaseFragment : Fragment() {

    fun displayProgressBar() {
        progressBar?.visibility = View.VISIBLE
    }

    fun removeProgressBar() {
        progressBar?.visibility = View.INVISIBLE
    }

    fun displayError() {
        Toast.makeText(activity, "There was an error retrieving the data", Toast.LENGTH_LONG).show()
    }
}