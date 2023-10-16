package com.kaylr.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        var btnSend = findViewById<Button>(R.id.bSend)
        var message = findViewById<EditText>(R.id.etMessage)

        btnSend.setOnClickListener{
            var sentText = message.text.toString()
            
            if (sentText.isNotEmpty()&&spacebarText(sentText)==1){
                var textIntent = Intent(this, SecondActivity::class.java)
                textIntent.putExtra("new_message",sentText)
                startActivity(textIntent)
            }
        }
    }
    private fun spacebarText(sentText: String ): Int {
        var confirmed = 0
            for (i in 1..254){
                if (sentText.contains(i.toChar()))
                         confirmed=1
            }
            return confirmed

    }
}