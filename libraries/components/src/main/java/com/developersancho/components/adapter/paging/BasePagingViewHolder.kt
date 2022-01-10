package com.developersancho.components.adapter.paging

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BasePagingViewHolder<T>(binding: ViewBinding) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: T)
}
