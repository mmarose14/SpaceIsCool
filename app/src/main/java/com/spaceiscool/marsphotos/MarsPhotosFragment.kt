package com.spaceiscool.marsphotos

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.spaceiscool.R
import com.spaceiscool.base.BaseFragment
import com.spaceiscool.data.MarsPhotosData
import kotlinx.android.synthetic.main.fragment_mars_photos.*

class MarsPhotosFragment : BaseFragment(), MarsPhotosContract.View, MarsPhotosAdapter.MarsPhotoListener {

    lateinit var presenter: MarsPhotosPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_mars_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = MarsPhotosPresenter(this)

        presenter.getMarsPhotos()
    }

    override fun displayMarsPhotos(photos: List<MarsPhotosData.Photo>) {
        context?.let {
            val marsPhotoAdapter = MarsPhotosAdapter(it, photos, this)
            mars_photos_list.layoutManager = LinearLayoutManager(it)
            mars_photos_list.adapter = marsPhotoAdapter

        }
    }

    override fun displayPhoto(photo: MarsPhotosData.Photo) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(photo.img_src)))
    }
}