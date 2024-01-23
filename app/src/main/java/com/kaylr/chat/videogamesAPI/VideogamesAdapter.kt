package com.kaylr.chat.videogamesAPI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R

//, private val navigateToDetailActivity: (String) -> Unit)
class VideogamesAdapter ( private var videogamesList: List<VideogamesItemResponse> = emptyList())
        : RecyclerView.Adapter<VideogamesViewHolder>(){
        fun updateList(list: List<VideogamesItemResponse>) {

                videogamesList = list
                notifyDataSetChanged()
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideogamesViewHolder {
                return VideogamesViewHolder(
                        LayoutInflater.from(parent.context).inflate(R.layout.item_videogame, parent, false)
                )
        }

        override fun onBindViewHolder(holder: VideogamesViewHolder, position: Int) {

                holder.bind(videogamesList[position])
        }

        override fun getItemCount() = videogamesList.size
}
