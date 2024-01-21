package com.kaylr.chat.videogamesAPI

import android.net.Uri
import android.util.Log
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
        Picasso.get().load(videogamesItemResponse.background_image?.toUri()).into(binding.ivVideogame)
        //por si no recibe ninguna imagen es importante poner el nuller "?" y luego castearlo a Uri.
        binding.tvVideogames.text = videogamesItemResponse.name
        binding.tvResultRating.text = videogamesItemResponse.rating?.toString()
        //binding.tvEsrbRating.text = videogamesItemResponse.esrb_rating?.name
        binding.tvResultEsrbRating.text = videogamesItemResponse.esrb_rating?.name
        if (videogamesItemResponse.platforms != null) {
            var longitud: Int = videogamesItemResponse.platforms.size -1
            var plataforma: String? = ""
            for (i in 0..longitud){
                plataforma = "$plataforma\n${videogamesItemResponse.platforms[i].platform?.name}"
                }
            binding.tvResultPlatforms.text = plataforma
            }

        //binding.root.setOnClickListener { navigateToDetailActivity(videogamesItemResponse.name) }
        //al ponerle root le decimos que hacemos referencia a cualquier parte del layout. Bien pulsemos el texto o la imagen, hará el setOnClick.
    }

}