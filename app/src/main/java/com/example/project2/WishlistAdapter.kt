package com.example.project2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WishAdapter(private val wishList: List<WishItem>) : RecyclerView.Adapter<WishAdapter.WishViewHolder>() {

    class WishViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val wishTextView: TextView = itemView.findViewById(R.id.wishTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wish, parent, false)
        return WishViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        holder.wishTextView.text = wishList[position].wish
    }

    override fun getItemCount() = wishList.size
}
