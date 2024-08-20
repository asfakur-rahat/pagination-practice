package com.ar.catpaging.presentation.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ar.catpaging.databinding.ItemSeperatorBinding

class SeparatorViewHolder(private val binding: ItemSeperatorBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(separatorText: String) {
        binding.separatorDescription.text = separatorText.uppercase()
    }

    companion object {
        fun create(view: ViewGroup): SeparatorViewHolder {
            val inflater = LayoutInflater.from(view.context)
            val binding = ItemSeperatorBinding.inflate(inflater, view, false)
            return SeparatorViewHolder(binding)
        }
    }
}