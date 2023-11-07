package com.kaylr.chat.colorPalette

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.core.graphics.alpha
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R
import com.kaylr.chat.boardGamesApp.GameCategory


class ColorPalette : AppCompatActivity() {
    private lateinit var rvVerticalColor: RecyclerView //RECYCLER_ColorPalette
    private lateinit var verticalColorAdapter: VerticalColorAdapter //RECYCLER_VerticalColor
    private lateinit var btnChangeColor: Button

    private val vColors = mutableListOf( //RECYCLER_verticalColors
        VerticalColor(R.string.v1_20.toString(), Color.argb(20,23,23,23)), //me ha obligado a cambiar la variable "Color" dentro de la data class a Int en vez de a Color.
        VerticalColor(R.string.v2_35.toString(), Color.argb(35,23,23,23)),
        VerticalColor(R.string.v3_50.toString(), Color.argb(50,23,23,23)),
        VerticalColor(R.string.v4_65.toString(), Color.argb(65,23,23,23)),
        VerticalColor(R.string.v5_80.toString(), Color.argb(80,23,23,23))
    )
    private fun initComponents() {
        rvVerticalColor = findViewById<RecyclerView>(R.id.rvVerticalColors)
        btnChangeColor = findViewById(R.id.btnChangeColor)
    }
    private fun initUI(){
       verticalColorAdapter = VerticalColorAdapter(vColors)//{ position -> onColorSelected(position) } //RECYCLER_vColor

        rvVerticalColor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) //RECYCLER_vColor

        rvVerticalColor.adapter = verticalColorAdapter //RECYCLER_vColor
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_palette)
        initComponents()
        initUI()
        initListeners()
    }
    private fun initListeners() { btnChangeColor.setOnClickListener{ showDialog() }
    }
    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_color_palette)
        val btnApplyColor: Button = dialog.findViewById(R.id.btnApplyColor)
        val rgBars: RadioGroup = dialog.findViewById(R.id.rgBars)
        val rgColors: RadioGroup = dialog.findViewById(R.id.rgColors)
        val cvH1: CardView = findViewById(R.id.cvHorizontalColor1)
        val cvH2: CardView = findViewById(R.id.cvHorizontalColor2)
        val cvH3: CardView = findViewById(R.id.cvHorizontalColor3)


        btnApplyColor.setOnClickListener {

            val selectedBarRadioButton: RadioButton = rgBars.findViewById(rgBars.checkedRadioButtonId)
            val selectedColorRadioButton: RadioButton = rgColors.findViewById(rgColors.checkedRadioButtonId)
            var currentColor: Int = R.color.black
            var op20: Int = vColors[0].color.alpha
            var op35: Int = vColors[1].color.alpha
            var op50: Int = vColors[2].color.alpha
            var op65: Int = vColors[3].color.alpha
            var op80: Int = vColors[4].color.alpha

            when(selectedColorRadioButton.text.toString()){
                getString(R.string.white) -> currentColor = R.color.white
                getString(R.string.red) -> currentColor = R.color.red
                getString(R.string.orange) -> currentColor = R.color.orange
                getString(R.string.yellow) -> currentColor = R.color.yellow
                getString(R.string.green) -> currentColor = R.color.green
                getString(R.string.turquoise) -> currentColor = R.color.turquoise
                getString(R.string.blue) -> currentColor = R.color.blue
                getString(R.string.purple) -> currentColor = R.color.purple
                getString(R.string.black) -> currentColor = R.color.black
            }
            when(selectedBarRadioButton.text.toString()){
                getString(R.string.h1_20) -> cvH1.setCardBackgroundColor(getColor(currentColor)) //si su texto es el de la String indicada, le asigna el color correspondiente
                getString(R.string.h2_50) -> cvH2.setCardBackgroundColor(getColor(currentColor))
                getString(R.string.h3_80) -> cvH3.setCardBackgroundColor(getColor(currentColor))
                getString(R.string.v1_20) -> vColors[0].color= getColor(currentColor)
                getString(R.string.v2_35) -> vColors[1].color= getColor(currentColor)
                getString(R.string.v3_50) -> vColors[2].color= getColor(currentColor)
                getString(R.string.v4_65) -> vColors[3].color= getColor(currentColor)
                getString(R.string.v5_80) -> vColors[4].color= getColor(currentColor)
            }

                //a la lista (dataclass) games le añadimos un juego pasandole el nombre de "currentGame" y la categoria de "currentCategory"
              /*  games.add(Game(currentGame, currentCategory))*/
                updateVerticalColors()
                dialog.hide()


        }
        dialog.show()


    }

    private fun updateVerticalColors() {
        //notificamos un cambio hecho a la lista (dataclass)games y gamesAdapter
        rvVerticalColor.adapter?.notifyDataSetChanged()

    }


}