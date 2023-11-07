package com.kaylr.chat.colorPalette

import android.app.Dialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kaylr.chat.R

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
            var currentColor: Array<Int> = arrayOf(R.color.black20,R.color.black35,R.color.black50,R.color.black65,R.color.black80)

            when(selectedColorRadioButton.text.toString()){
                getString(R.string.white) -> currentColor = arrayOf(R.color.white20,R.color.white35,R.color.white50,R.color.white65,R.color.white80)
                getString(R.string.red) -> currentColor = arrayOf(R.color.red20,R.color.red35,R.color.red50,R.color.red65,R.color.red80)
                getString(R.string.orange) -> currentColor = arrayOf(R.color.orange20,R.color.orange35,R.color.orange50,R.color.orange65,R.color.orange80)
                getString(R.string.yellow) -> currentColor = arrayOf(R.color.yellow20,R.color.yellow35,R.color.yellow50,R.color.yellow65,R.color.yellow80)
                getString(R.string.green) -> currentColor = arrayOf(R.color.green20,R.color.green35,R.color.green50,R.color.green65,R.color.green80)
                getString(R.string.turquoise) -> currentColor = arrayOf(R.color.turquoise20,R.color.turquoise35,R.color.turquoise50,R.color.turquoise65,R.color.turquoise80)
                getString(R.string.blue) -> currentColor = arrayOf(R.color.blue20,R.color.blue35,R.color.blue50,R.color.blue65,R.color.blue80)
                getString(R.string.purple) -> currentColor = arrayOf(R.color.purple20,R.color.purple35,R.color.purple50,R.color.purple65,R.color.purple80)
                getString(R.string.black) -> currentColor = arrayOf(R.color.black20,R.color.black35,R.color.black50,R.color.black65,R.color.black80)
            }
            when(selectedBarRadioButton.text.toString()){
                getString(R.string.h1_20) -> cvH1.setCardBackgroundColor(getColor(currentColor[0])) //si su texto es el de la String indicada, le asigna el color correspondiente
                getString(R.string.h2_50) -> cvH2.setCardBackgroundColor(getColor(currentColor[2]))
                getString(R.string.h3_80) -> cvH3.setCardBackgroundColor(getColor(currentColor[4]))
                getString(R.string.v1_20) -> vColors[0].color= getColor(currentColor[0])
                getString(R.string.v2_35) -> vColors[1].color= getColor(currentColor[1])
                getString(R.string.v3_50) -> vColors[2].color= getColor(currentColor[2])
                getString(R.string.v4_65) -> vColors[3].color= getColor(currentColor[3])
                getString(R.string.v5_80) -> vColors[4].color= getColor(currentColor[4])
            }
                updateVerticalColors()
                dialog.hide()
        }
        dialog.show()
    }
    private fun updateVerticalColors() {
        //notificamos un cambio hecho a la lista (dataclass) VerticalColor
        rvVerticalColor.adapter?.notifyDataSetChanged()
    }
}