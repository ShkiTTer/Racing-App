package com.example.racingapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.racingapp.R
import com.example.racingapp.domain.entity.championship.ChampionShip
import com.example.racingapp.domain.entity.championship.ChampionShipState
import com.example.racingapp.presentation.adapter.common.ViewHolder
import kotlinx.android.synthetic.main.item_championship.view.*

class TournamentAdapter :
    BaseAdapter<ChampionShip, TournamentAdapter.TournamentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentViewHolder =
        TournamentViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_championship,
                parent,
                false
            )
        )

    class TournamentViewHolder(v: View) : ViewHolder<ChampionShip>(v) {
        private val title = v.tvTitle
        private val status = v.tvStatus

        init {
            v.setOnClickListener {
                onItemClickListener?.onItemClick(adapterPosition)
            }
        }

        override fun bind(item: ChampionShip) {
            title.text = item.title
            status.setText(
                if (item.state == ChampionShipState.BEGIN)
                    R.string.championship_state_begin
                else R.string.championship_state_ended
            )
        }
    }
}