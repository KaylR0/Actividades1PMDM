package com.kaylr.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kaylr.chat.boardGamesApp.BoardgameActivity

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
        val btnBoardgame = findViewById<Button>(R.id.btnBoardgame)
        btnBoardgame.setOnClickListener {navigateToBoardgame()}
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
    private fun navigateToBoardgame(){
        val intent = Intent(this, BoardgameActivity::class.java)
        startActivity(intent)
    }
}