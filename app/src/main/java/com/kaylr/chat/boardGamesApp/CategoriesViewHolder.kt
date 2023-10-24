package com.kaylr.chat.boardGamesApp

import android.graphics.Paint
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    //el viewHolder modifica los objetos
    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val viewContainer: CardView = view.findViewById(R.id.viewContainer)

    fun render(gameCategory: GameCategory, onItemSelected: (Int) -> Unit){
        //Si la categoria está seleccionada que cambie de color
       val color = if (gameCategory.isSelected){
           R.color.bgapp_background_card
       }else{
           R.color.bgapp_background_disabled
       }
        viewContainer.setCardBackgroundColor(ContextCompat.getColor(viewContainer.context, color))
        itemView.setOnClickListener{ onItemSelected(layoutPosition) }

        when(gameCategory){
            GameCategory.Cooperative -> {
                tvCategoryName.text = "Cooperative"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_cooperative_category))
            }
            GameCategory.Deckbuilding -> {
                tvCategoryName.text = "Deck Building"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_deckbuilding_category))
            }
            GameCategory.Euro -> {tvCategoryName.text = "Euro"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_euro_category))
            }
            GameCategory.LCG -> {tvCategoryName.text = "LCG"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_lcg_category))
            }
            GameCategory.Legacy -> {tvCategoryName.text = "Legacy"
                divider.setBackgroundColor(getColor(divider.context, R.color.bgapp_legacy_category))
            }
        }
    }
}
