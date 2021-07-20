package com.example.nhie.store

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nhie.R
import com.example.nhie.databinding.ItemStoreBinding

class StoreAdapter(val clickListener: StoreItemListener) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>() {

    var data = listOf<StoreItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, clickListener)
    }

    override fun getItemCount() = data.size


    class ViewHolder private constructor(val binding: ItemStoreBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: StoreItem, clickListener: StoreItemListener) {
            binding.clickListener = clickListener
            binding.storeItem = item
            binding.executePendingBindings()
            if (adapterPosition % 2 == 1) {
                binding.itemStoreClBackground.setBackgroundResource(R.drawable.storescreen_element_shadow_dline)
            } else {
                binding.itemStoreClBackground.setBackgroundResource(R.color.store_background_items_light_grey)
            }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemStoreBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}

class StoreItemListener(val clickListener: (storeItem: StoreItem) -> Unit) {
    fun onClick(storeItem: StoreItem) = clickListener(storeItem)
}