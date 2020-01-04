package com.example.racingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racingapp.R
import com.example.racingapp.domain.entity.result.RacerResult
import com.example.racingapp.presentation.adapter.common.BaseAdapter
import com.example.racingapp.presentation.adapter.common.ViewHolder
import kotlinx.android.synthetic.main.item_result.view.*

class RacerResultAdapter : BaseAdapter<RacerResult, RacerResultAdapter.RacerResultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RacerResultViewHolder =
        RacerResultViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_result,
                parent,
                false
            )
        )

    class RacerResultViewHolder(v: View) : ViewHolder<RacerResult>(v) {
        private val place = v.tvPlace
        private val title = v.tvTitle
        private val time = v.tvTime
        private val points = v.tvPoints

        override fun bind(item: RacerResult) {
            place.text = item.place.toString()
            title.text = item.title
            time.text = item.time
            points.text = item.points.toString()
        }
    }
}