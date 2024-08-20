package com.ar.catpaging.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ar.catpaging.R
import com.ar.catpaging.databinding.ItemCatBinding
import com.ar.catpaging.domain.model.Cat

class CatViewHolder(private val binding: ItemCatBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Cat?) {
        binding.imageCat.load(item?.url) {
            placeholder(R.drawable.ic_launcher_background)
        }
    }

    companion object {
        fun create(view: ViewGroup): CatViewHolder {
            val inflater = LayoutInflater.from(view.context)
            val binding = ItemCatBinding.inflate(inflater, view, false)
            return CatViewHolder(binding)
        }
    }
}