package com.spaceiscool.base

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    fun displayProgressBar() {
        //Do nothing
    }

    fun removeProgressBar() {
        //Do nothing
    }

    fun displayError() {
        Toast.makeText(activity, "There was an error retrieving the data", Toast.LENGTH_LONG).show()
    }

    fun displayPhotoInBrowser(imageUrl: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(imageUrl)))
    }
}