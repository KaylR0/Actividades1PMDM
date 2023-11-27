package com.kaylr.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.kaylr.chat.colorPalette.ColorPalette
import com.kaylr.chat.boardGamesApp.BoardgameActivity
import com.kaylr.chat.recyclerViewSimple.RvSimple
import com.kaylr.chat.superHeroApp.SuperHeroActivity

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
        val btnColorPalette = findViewById<Button>(R.id.btnColorPalette)
        btnColorPalette.setOnClickListener{ navigateToColorPalette() }
        val btnRvSimple = findViewById<Button>(R.id.btnRvSimple)
        btnRvSimple.setOnClickListener{ navigateToRvSimple() }
        val btnSuperHero = findViewById<Button>(R.id.btnSuperHero)
        btnSuperHero.setOnClickListener{ navigateToSuperHeroApp() }


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
    private fun navigateToColorPalette(){
        val intent = Intent(this, ColorPalette::class.java)
        startActivity(intent)
    }private fun navigateToRvSimple(){
        val intent = Intent(this, RvSimple::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperHeroApp(){
        val intent = Intent(this, SuperHeroActivity::class.java)
        startActivity(intent)
    }
}