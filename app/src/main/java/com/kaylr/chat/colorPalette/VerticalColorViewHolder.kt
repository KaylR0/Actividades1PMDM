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
            R.string.v1_20.toString() -> {
                tvVerticalColor.text = "V1 (20%)"
                viewContainerVC.setBackgroundColor(
                    ContextCompat.getColor(
                        viewContainerVC.context,
                        R.color.v_color1_20
                    )
                )
            }
            R.string.v2_35.toString() -> {
                tvVerticalColor.text = "V2 (35%)"
                viewContainerVC.setBackgroundColor(
                    ContextCompat.getColor(
                        viewContainerVC.context,
                        R.color.v_color2_35
                    )
                )
            }
            R.string.v3_50.toString() -> {
                tvVerticalColor.text = "V3 (50%)"
                viewContainerVC.setBackgroundColor(
                    ContextCompat.getColor(
                        viewContainerVC.context,
                        R.color.v_color3_50
                    )
                )
            }
            R.string.v4_65.toString() -> {
                tvVerticalColor.text = "V4 (65%)"
                viewContainerVC.setBackgroundColor(
                    ContextCompat.getColor(
                        viewContainerVC.context,
                        R.color.v_color4_65
                    )
                )
            }
            R.string.v5_80.toString() -> {
                tvVerticalColor.text = "V5 (80%)"
                viewContainerVC.setBackgroundColor(
                    ContextCompat.getColor(
                        viewContainerVC.context,
                        R.color.v_color5_80
                    )
                )
            }
        }
    }
}