package com.example.racingapp.presentation.adapter.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ViewHolder<T>(v: View) : RecyclerView.ViewHolder(v) {
    abstract fun bind(item: T)
}