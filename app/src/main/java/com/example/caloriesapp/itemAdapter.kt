package com.example.caloriesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemAdapter(
    private val itemList: List<item>,
    private val clickListener: (Int) -> Unit
) : RecyclerView.Adapter<itemAdapter.ViewHolder>() {
    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private lateinit var txtName: TextView
        fun bind(item: item) {
            txtName = view.findViewById(android.R.id.text1)
            txtName.text = item.itemName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = android.R.layout.simple_list_item_1
        return ViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.view.setOnClickListener { clickListener(position) }
    }
}