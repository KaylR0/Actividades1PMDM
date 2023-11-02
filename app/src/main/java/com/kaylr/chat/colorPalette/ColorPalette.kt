package com.kaylr.chat.colorPalette

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R
import com.kaylr.chat.boardGamesApp.CategoriesAdapter
import com.kaylr.chat.boardGamesApp.GamesAdapter
import com.kaylr.chat.colorPalette.VerticalColor
import com.kaylr.chat.colorPalette.VerticalColorAdapter

class ColorPalette : AppCompatActivity() {
    private lateinit var rvVerticalColor: RecyclerView //RECYCLER_ColorPalette
    private lateinit var verticalColorAdapter: VerticalColorAdapter //RECYCLER_VerticalColor

    private val vColors = mutableListOf( //RECYCLER_verticalColors
        VerticalColor("V1 (20%)", Color.argb(20,23,23,23)), //me ha obligado a cambiar la variable "Color" dentro de la data class a Int en vez de a Color.
        VerticalColor("V2 (35%)", Color.argb(35,23,23,23)),
        VerticalColor("V3 (50%)", Color.argb(50,23,23,23)),
        VerticalColor("V4 (65%)", Color.argb(65,23,23,23)),
        VerticalColor("V5 (80%)", Color.argb(80,23,23,23))
    )
    private fun initComponents() {
        rvVerticalColor = findViewById<RecyclerView>(R.id.rvCategories)
    }
    private fun initUI(){
       // verticalColorAdapter = CategoriesAdapter(vColors){ position -> onColorSelected(position) } //RECYCLER_vColor

        rvVerticalColor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) //RECYCLER_vColor

        rvVerticalColor.adapter = verticalColorAdapter //RECYCLER_vColor
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_palette)
        initComponents()
        initUI()
    }
}