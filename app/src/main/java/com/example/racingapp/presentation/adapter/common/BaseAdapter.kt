package com.example.racingapp.presentation.adapter.common

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : ViewHolder<T>> :
    RecyclerView.Adapter<VH>() {

    companion object {
        var onItemClickListener: OnItemClickListener? = null
    }

    private val items = mutableListOf<T>()

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }
}