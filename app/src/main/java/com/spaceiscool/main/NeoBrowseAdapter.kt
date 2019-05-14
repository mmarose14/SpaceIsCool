package com.spaceiscool.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.spaceiscool.R
import com.spaceiscool.data.NearEarthObjectFull
import kotlinx.android.synthetic.main.neo_item_browse.view.*

class NeoBrowseAdapter(val context: Context, private val objects: List<NearEarthObjectFull.NearEarthObject>) :
        RecyclerView.Adapter<NeoBrowseAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.neo_item_browse, parent, false))
    }

    override fun getItemCount() = objects.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = objects[position].name
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var titleView: AppCompatTextView = view.neo_name
    }
}