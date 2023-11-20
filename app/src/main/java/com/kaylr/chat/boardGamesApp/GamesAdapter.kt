package com.kaylr.chat.boardGamesApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R

class GamesAdapter (var games: List<Game>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<GamesViewHolder>() {                            //Unit corresponde a void

    //metodo que le pasa cada uno de los views de juegos al viewholder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
            return GamesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return games.size
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.render(games[position])
        holder.itemView.setOnClickListener{onItemSelected(position)}
    }
}