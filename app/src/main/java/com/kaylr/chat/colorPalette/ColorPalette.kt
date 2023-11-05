package com.kaylr.chat.colorPalette

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R
import com.kaylr.chat.boardGamesApp.CategoriesAdapter
import com.kaylr.chat.boardGamesApp.Game
import com.kaylr.chat.boardGamesApp.GameCategory
import com.kaylr.chat.boardGamesApp.GamesAdapter
import com.kaylr.chat.colorPalette.VerticalColor
import com.kaylr.chat.colorPalette.VerticalColorAdapter

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
        val rgColor: RadioGroup = dialog.findViewById(R.id.rgColors)
        val cvH1: CardView = findViewById(R.id.cvHorizontalColor1)
        val cvH2: CardView = findViewById(R.id.cvHorizontalColor2)
        val cvH3: CardView = findViewById(R.id.cvHorizontalColor3)

        btnApplyColor.setOnClickListener {
                val selectedBarId = rgBars.checkedRadioButtonId
                val selectedColorId = rgColor.checkedRadioButtonId
                val selectedBarRadioButton: RadioButton = rgBars.findViewById(selectedBarId)
                val selectedColorRadioButton: RadioButton = rgBars.findViewById(selectedColorId)

                    when(selectedBarRadioButton.text){
                        getString(R.string.h1_20) -> cvH1.setCardBackgroundColor(selectedColorRadioButton.currentTextColor) //si su texto es el de la String indicada, le asigna el color correspondiente
                        getString(R.string.h2_50) -> cvH2.setCardBackgroundColor(selectedColorRadioButton.currentTextColor)
                        getString(R.string.h3_80) -> cvH3.setCardBackgroundColor(selectedColorRadioButton.currentTextColor)
                        getString(R.string.v1_20) -> vColors
                        getString(R.string.v2_35) -> vColors
                        getString(R.string.v3_50) -> vColors
                        getString(R.string.v4_65) -> vColors
                        getString(R.string.v5_80) -> vColors
                    }
                //a la lista (dataclass) games le añadimos un juego pasandole el nombre de "currentGame" y la categoria de "currentCategory"
           /*     games.add(Game(currentGame, currentCategory))
                updateGames()
                dialog.hide()

            }*/
        }
        dialog.show()


    }


}