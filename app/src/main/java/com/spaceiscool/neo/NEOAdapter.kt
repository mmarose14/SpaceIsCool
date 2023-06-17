package com.spaceiscool.neo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.spaceiscool.data.model.neo.NearEarthObject
import com.spaceiscool.databinding.NeoItemBrowseBinding

class NEOAdapter : ListAdapter<NearEarthObject, RecyclerView.ViewHolder>(NEODiffCallback()) {

    var listener: NEOListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = NeoItemBrowseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NEOViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is NEOViewHolder -> {
                holder.bind(getItem(position))
            }
        }
    }

    inner class NEOViewHolder(private val binding: NeoItemBrowseBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(neo: NearEarthObject) {
            binding.apply {
                val stringBuilder = StringBuilder()
                stringBuilder.append(neo.name)
                stringBuilder.append(" (")
                stringBuilder.append(neo.id)
                stringBuilder.append(")")
                neoName.text = stringBuilder.toString()

                root.setOnClickListener {
                    listener?.onNEOClicked(neo)
                }
            }
        }
    }

    class NEODiffCallback: DiffUtil.ItemCallback<NearEarthObject>() {
        override fun areItemsTheSame(oldItem: NearEarthObject, newItem: NearEarthObject): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NearEarthObject, newItem: NearEarthObject): Boolean {
            return oldItem == newItem
        }
    }

    interface NEOListener {
        fun onNEOClicked(neo: NearEarthObject)
    }
}