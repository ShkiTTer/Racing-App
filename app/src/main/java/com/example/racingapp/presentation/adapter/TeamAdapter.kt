package com.example.racingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racingapp.R
import com.example.racingapp.domain.entity.Team
import com.example.racingapp.presentation.adapter.common.BaseAdapter
import com.example.racingapp.presentation.adapter.common.ViewHolder
import kotlinx.android.synthetic.main.item_list.view.*

class TeamAdapter: BaseAdapter<Team, TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder =
        TeamViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )

    class TeamViewHolder(v: View) : ViewHolder<Team>(v) {
        private val title = v.tvTitle

        init {
            v.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }

        override fun bind(item: Team) {
            title.text = item.title
        }
    }
}