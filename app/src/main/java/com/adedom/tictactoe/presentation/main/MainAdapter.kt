package com.adedom.tictactoe.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.adedom.tictactoe.R
import com.adedom.tictactoe.presentation.model.GameMode
import kotlinx.android.synthetic.main.item_main.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var onClickListener: ((GameMode) -> Unit)? = null

    private val diffUtil = object : DiffUtil.ItemCallback<GameMode>() {
        override fun areItemsTheSame(oldItem: GameMode, newItem: GameMode): Boolean {
            return oldItem.modeId == newItem.modeId
        }

        override fun areContentsTheSame(oldItem: GameMode, newItem: GameMode): Boolean {
            return oldItem == newItem
        }
    }

    private val asyncListDiffer = AsyncListDiffer(this, diffUtil)

    private val list: List<GameMode>
        get() = asyncListDiffer.currentList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.itemView.apply {
            val item = list[position]

            tvMode.text = item.modeName

            setOnClickListener {
                onClickListener?.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun submitList(list: List<GameMode>) = asyncListDiffer.submitList(list)

    fun setOnClickListener(onClickListener: (GameMode) -> Unit) {
        this.onClickListener = onClickListener
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
