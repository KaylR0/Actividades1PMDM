package com.kaylr.chat.colorPalette

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R
import com.kaylr.chat.boardGamesApp.GamesViewHolder

class VerticalColorAdapter (private val color: List<VerticalColor>) :
RecyclerView.Adapter<VerticalColorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalColorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_color, parent, false)
        return VerticalColorViewHolder(view)
    }

    override fun onBindViewHolder(holder: VerticalColorViewHolder, position: Int) {
        holder.render(color[position])
    }

    override fun getItemCount()=color.size

}