package com.spaceiscool.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.spaceiscool.R
import com.spaceiscool.base.BaseFragment
import com.spaceiscool.data.NearEarthObjectFull
import com.spaceiscool.marsphotos.MarsPhotosActivity
import com.spaceiscool.pictureoftheday.APODActivity
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), MainPresenterContract.View {
    private lateinit var presenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MainPresenter(this)
        presenter.getNEOBrowse()

        setupView()

    }

    private fun setupView() {
        button_mars_photos.setOnClickListener {
            startActivity(Intent(activity, MarsPhotosActivity::class.java))
        }

        button_apod.setOnClickListener {
            startActivity(Intent(activity, APODActivity::class.java))
        }
    }

    override fun displayNEOs(near_earth_objects: List<NearEarthObjectFull.NearEarthObject>) {
        context?.let {
            val neoListAdapter = NeoBrowseAdapter(it, near_earth_objects)
            neo_list.layoutManager = LinearLayoutManager(it)
            neo_list.adapter = neoListAdapter
        }

    }
}