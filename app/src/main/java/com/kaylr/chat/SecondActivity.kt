package com.kaylr.chat

import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var chat = findViewById<TextView>(R.id.tvFirstMessage)
        var newMessage: String = intent.extras?.getString("new_message").orEmpty()
        chat.text = newMessage

        var btnSend = findViewById<Button>(R.id.bSend)
        var message = findViewById<EditText>(R.id.etMessage)

        btnSend.setOnClickListener{
            var sentText = message.text.toString()
            if(sentText.isNotEmpty()) {
                chat.text = "${chat.text} \n$sentText"
                message.setText("")
            }
        }
    }
}