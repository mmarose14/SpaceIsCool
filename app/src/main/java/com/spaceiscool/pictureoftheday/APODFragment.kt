package com.spaceiscool.pictureoftheday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.spaceiscool.R
import com.spaceiscool.base.BaseFragment
import com.spaceiscool.data.APOD
import kotlinx.android.synthetic.main.fragment_apod.*

class APODFragment: BaseFragment(), APODContract.View {

    lateinit var presenter: APODPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_apod, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = APODPresenter(this)
        presenter.getPhotoOfTheDay()
    }

    override fun showAPOD(apod: APOD) {
        apod_title.text = apod.title
        apod_description.text = apod.explanation

        button_read_more.setOnClickListener {
            //TODO: Display full description
        }

        apod_image.setOnClickListener {
            displayPhotoInBrowser(apod.url)
        }

        Glide.with(this)
            .load(apod.url)
            .placeholder(R.drawable.mars_default)
            .into(apod_image)

    }
}