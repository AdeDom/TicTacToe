package com.adedom.tictactoe.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adedom.tictactoe.R

class HeaderAdapter : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_header, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
    }

    override fun getItemCount(): Int = 1

    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
