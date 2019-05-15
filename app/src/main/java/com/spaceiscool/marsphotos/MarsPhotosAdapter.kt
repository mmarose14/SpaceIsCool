package com.spaceiscool.marsphotos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.spaceiscool.R
import com.spaceiscool.data.MarsPhotosData
import kotlinx.android.synthetic.main.mars_photo_item.view.*

class MarsPhotosAdapter(private val context: Context,
                        private val objects: List<MarsPhotosData.Photo>,
                        private val listener: MarsPhotoListener) :
        RecyclerView.Adapter<MarsPhotosAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.mars_photo_item, parent, false))
    }

    override fun getItemCount() = objects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = objects[position]

        holder.photoTitle.text = photo.id.toString()
        holder.photoDate.text = photo.earth_date

        //Android 9 doesn't allow cleartext traffic: https://developer.android.com/training/articles/security-config#CleartextTrafficPermitted
        val imgUrl = photo.img_src.replace("http","https")

        Glide.with(context)
            .load(imgUrl)
            .placeholder(R.drawable.mars_default)
            .into(holder.imgPhoto)

        holder.imgPhoto.setOnClickListener {
            listener.displayPhoto(photo)
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imgPhoto: AppCompatImageView = view.img_photo
        var photoTitle: AppCompatTextView = view.photo_title
        var photoDate: AppCompatTextView = view.date
    }

    interface MarsPhotoListener {
        fun displayPhoto(photo: MarsPhotosData.Photo)
    }
}