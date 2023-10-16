package com.kaylr.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)

        var btnHi = findViewById<Button>(R.id.btnName)
        btnHi.setOnClickListener{sendName()}
    }

    private fun sendName(){
        var nameText = findViewById<EditText>(R.id.etName)
        var helloName = findViewById<TextView>(R.id.tvHello)
        helloName.text = "Hello ${nameText.text}"


    }
}