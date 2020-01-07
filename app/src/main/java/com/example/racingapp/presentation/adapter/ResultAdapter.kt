package com.example.racingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racingapp.R
import com.example.racingapp.domain.entity.result.Result
import com.example.racingapp.presentation.adapter.common.BaseAdapter
import com.example.racingapp.presentation.adapter.common.ViewHolder
import kotlinx.android.synthetic.main.item_result.view.*

class ResultAdapter : BaseAdapter<Result<*>, ResultAdapter.TeamResultViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamResultViewHolder =
        TeamResultViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_result,
                parent,
                false
            )
        )

    class TeamResultViewHolder(v: View) : ViewHolder<Result<*>>(v) {
        private val place = v.tvPlace
        private val title = v.tvTitle
        private val points = v.tvPoints

        override fun bind(item: Result<*>) {
            place.text = item.place.toString()
            title.text = item.subject.toString()
            points.text = item.points.toString()
        }
    }
}