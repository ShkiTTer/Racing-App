package com.example.racingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racingapp.R
import com.example.racingapp.domain.entity.request.Request
import com.example.racingapp.domain.entity.request.RequestState
import com.example.racingapp.presentation.adapter.common.BaseAdapter
import com.example.racingapp.presentation.adapter.common.ViewHolder
import kotlinx.android.synthetic.main.item_list.view.*

class RequestAdapter : BaseAdapter<Request, RequestAdapter.RequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RequestViewHolder =
        RequestViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )

    class RequestViewHolder(v: View) : ViewHolder<Request>(v) {
        private val title = v.tvTitle
        private val status = v.tvStatus

        init {
            v.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }

        override fun bind(item: Request) {
            title.text = "${item.team} - ${item.tournament}"
            status.setText(
                when (item.state) {
                    RequestState.FILED -> R.string.request_status_filed
                    RequestState.APPROVED -> R.string.request_status_approved
                    RequestState.REJECTED -> R.string.request_status_rejected
                }
            )
        }
    }
}