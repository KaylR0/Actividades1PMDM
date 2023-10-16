package com.kaylr.chat

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import kotlin.math.pow

class IMCAppActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 70
    private var currentAge: Int = 30
    private var currentHeight: Double = 120.0

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvWeight: TextView
    private lateinit var btnSubstractWeight: CardView
    private lateinit var btnAddWeight: CardView
    private lateinit var tvAge: TextView
    private lateinit var btnSubstractAge: CardView
    private lateinit var btnAddAge: CardView
    private lateinit var calculate: CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcapp)
        initComponents()
        initListeners()
        setWeight()
        setAge()
    }

    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubstractWeight = findViewById(R.id.weightMinus)
        btnAddWeight = findViewById(R.id.weightPlus)
        tvAge = findViewById(R.id.tvAge)
        btnSubstractAge = findViewById(R.id.ageMinus)
        btnAddAge = findViewById(R.id.agePlus)
        calculate = findViewById(R.id.calculate)
    }
    private fun initListeners(){
        viewMale.setOnClickListener{setColorComponentMale()}
        viewFemale.setOnClickListener{setColorComponentFemale()}
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#")
            currentHeight = df.format(value).toDouble()
            tvHeight.text = "$currentHeight cm"
        }
        btnSubstractWeight.setOnClickListener{
            currentWeight -= 1
            setWeight()
        }
        btnAddWeight.setOnClickListener{
            currentWeight += 1
            setWeight()
        }
        btnSubstractAge.setOnClickListener{
            currentAge -= 1
            setAge()
        }
        btnAddAge.setOnClickListener{
            currentAge += 1
            setAge()
        }
        calculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }

    private fun setColorComponentMale() {
        if (!isMaleSelected){
            viewMale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = true
            isFemaleSelected = false
        }
    }
    private fun setColorComponentFemale() {
        if (!isFemaleSelected){
            viewFemale.setCardBackgroundColor(getColor(R.color.background_component_selected))
            viewMale.setCardBackgroundColor(getColor(R.color.background_component))
            isMaleSelected = false
            isFemaleSelected = true
        }
    }
    private fun setWeight(){ tvWeight.text = currentWeight.toString() }
    private fun setAge() { tvAge.text = currentAge.toString() }
    private fun calculateIMC(): Double {
        val dfs = DecimalFormatSymbols()
        dfs.decimalSeparator = '.'
        val df = DecimalFormat("#.##")
        df.decimalFormatSymbols = dfs
        val imc = currentWeight/ Math.pow(currentHeight / 100,2.0)

        return df.format(imc).toDouble()
    }
    private fun navigateToResult(result: Double){
        var intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("extra_IMC", result)
        startActivity(intent)

    }
}