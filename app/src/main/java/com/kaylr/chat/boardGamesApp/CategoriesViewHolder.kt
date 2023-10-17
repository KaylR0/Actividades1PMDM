package com.kaylr.chat.boardGamesApp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R

class CategoriesViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val divider: View = view.findViewById(R.id.divider)

    fun render(gameCategory: GameCategory){
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
