package com.example.racingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racingapp.R
import com.example.racingapp.domain.entity.Race
import com.example.racingapp.presentation.adapter.common.BaseAdapter
import com.example.racingapp.presentation.adapter.common.ViewHolder
import kotlinx.android.synthetic.main.item_list.view.*

class RaceAdapter : BaseAdapter<Race, RaceAdapter.RaceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RaceViewHolder =
        RaceViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )

    class RaceViewHolder(v: View) : ViewHolder<Race>(v) {
        private val title = v.tvTitle

        init {
            v.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }

        override fun bind(item: Race) {
            title.text = item.title
        }
    }
}