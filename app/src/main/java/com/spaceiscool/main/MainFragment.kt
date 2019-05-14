package com.spaceiscool.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.spaceiscool.R
import com.spaceiscool.data.NearEarthObjectFull
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), MainPresenterContract.View {
    private lateinit var presenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MainPresenter(this)

        presenter.getNEOBrowse()

    }

    override fun displayNEOs(near_earth_objects: List<NearEarthObjectFull.NearEarthObject>) {
        val neoListAdapter = NeoBrowseAdapter(context!!, near_earth_objects)
        neo_list.layoutManager = LinearLayoutManager(context)
        neo_list.adapter = neoListAdapter
    }

    override fun displayError() {

    }
}