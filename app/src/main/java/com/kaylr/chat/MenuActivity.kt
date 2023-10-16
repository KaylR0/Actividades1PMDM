package com.kaylr.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener{navigateToHelloApp()}
        val btnChat = findViewById<Button>(R.id.btnChat)
        btnChat.setOnClickListener{navigateToChat()}
        val btnIMC = findViewById<Button>(R.id.btnIMC)
        btnIMC.setOnClickListener{navigateToIMCCalc()}
    }
    private fun navigateToHelloApp(){
        val intent = Intent(this, HelloActivity::class.java)
        startActivity(intent)

    }
    private fun navigateToChat(){
        val intent = Intent(this, ChatActivity::class.java)
        startActivity(intent)

    }
    private fun navigateToIMCCalc(){
        val intent = Intent(this, IMCAppActivity::class.java)
        startActivity(intent)

    }
}