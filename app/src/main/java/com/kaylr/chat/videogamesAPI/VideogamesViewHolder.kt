package com.kaylr.chat.videogamesAPI

import android.net.Uri
import android.view.View
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.databinding.ItemVideogameBinding
import com.squareup.picasso.Picasso

class VideogamesViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemVideogameBinding.bind(view)

    //, navigateToDetailActivity: (String) -> Unit
    fun bind(videogamesItemResponse: VideogamesItemResponse) {
        //recibe los items de la lista
        Picasso.get().load(videogamesItemResponse.background_image.toUri()).into(binding.ivVideogame);
        binding.tvVideogames.text = videogamesItemResponse.name
        //binding.root.setOnClickListener { navigateToDetailActivity(videogamesItemResponse.name) }
        //al ponerle root le decimos que hacemos referencia a cualquier parte del layout. Bien pulsemos el texto o la imagen, hará el setOnClick.
    }

}