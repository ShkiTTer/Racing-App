package com.example.racingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racingapp.R
import com.example.racingapp.domain.entity.Track
import com.example.racingapp.presentation.adapter.common.BaseAdapter
import com.example.racingapp.presentation.adapter.common.ViewHolder
import kotlinx.android.synthetic.main.item_track.view.*

class TrackAdapter : BaseAdapter<Track, TrackAdapter.TrackViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder =
        TrackViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_track,
                parent,
                false
            )
        )

    class TrackViewHolder(v: View) : ViewHolder<Track>(v) {
        private val title = v.tvTitle
        private val country = v.tvCountry
        private val length = v.tvLength

        init {
            v.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }

        override fun bind(item: Track) {
            title.text = item.title
            country.text = item.country
            length.text = "${item.length}m"
        }
    }
}