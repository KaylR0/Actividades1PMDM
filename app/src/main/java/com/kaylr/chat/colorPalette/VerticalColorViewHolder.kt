package com.kaylr.chat.colorPalette

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R
import com.kaylr.chat.boardGamesApp.GameCategory

class VerticalColorViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val viewContainerVC: CardView = view.findViewById(R.id.viewContainerVerticalColor)
    private val tvVerticalColor:TextView = view.findViewById(R.id.tvVerticalColor)
    fun render(vColor: VerticalColor){
        when(vColor.name){
            VerticalColor.name -> {
                tvVerticalColor.text = "V1 (20%)"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.bgapp_cooperative_category
                    )
                )
            }
            GameCategory.Deckbuilding -> {
                tvVerticalColor.text = "V2 (35%)"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.bgapp_deckbuilding_category
                    )
                )
            }
            GameCategory.Euro -> {
                tvVerticalColor.text = "V3 (50%)"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.bgapp_euro_category
                    )
                )
            }
            GameCategory.LCG -> {
                tvVerticalColor.text = "V4 (65%)"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.bgapp_lcg_category
                    )
                )
            }
            GameCategory.Legacy -> {
                tvVerticalColor.text = "V5 (80%)"
                divider.setBackgroundColor(
                    ContextCompat.getColor(
                        divider.context,
                        R.color.bgapp_legacy_category
                    )
                )
            }
        }
    }
}