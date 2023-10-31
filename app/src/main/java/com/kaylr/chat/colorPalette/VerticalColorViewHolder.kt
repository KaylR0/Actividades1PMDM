package com.kaylr.chat.colorPalette

import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R
import com.kaylr.chat.boardGamesApp.GameCategory

class VerticalColorViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val viewContainerVC: CardView = view.findViewById(R.id.viewContainerVerticalColor)
    fun render(vColor: VerticalColor){
        val color =
            when(vColor.opacity){
                20 -> R.color.bgapp_cooperative_category
                35 -> R.color.bgapp_deckbuilding_category
                50 -> R.color.bgapp_euro_category
                65 -> R.color.bgapp_lcg_category
        /*80*/ else -> R.color.bgapp_legacy_category
            }
    }
}