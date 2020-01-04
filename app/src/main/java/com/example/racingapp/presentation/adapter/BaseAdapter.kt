package com.example.racingapp.presentation.adapter

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.racingapp.presentation.adapter.common.OnItemClickListener
import com.example.racingapp.presentation.adapter.common.ViewHolder

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