package com.example.myapplication.ui.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemMainBinding
import java.util.*

class MainAdapter(var onClick: ((Intent?) -> Unit)? = null) :
    RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private val itemList = LinkedList<Pair<Intent,String>>()

    fun replaceItems(lists: List<Pair<Intent, String>>) {
        itemList.addAll(lists)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ListItemMainBinding.inflate(LayoutInflater.from(parent.context))
        return MainViewHolder(binding).apply {
            itemView.setOnClickListener { onClick?.invoke(itemList[adapterPosition].first) }
        }
    }


    override fun onBindViewHolder(holder: MainViewHolder, position: Int) =
        holder.bind(itemList[position].second)

    override fun getItemCount(): Int = itemList.size

    data class MainViewHolder(private val binding: ListItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(text: String) {
            binding.button.text = text
        }

    }
}