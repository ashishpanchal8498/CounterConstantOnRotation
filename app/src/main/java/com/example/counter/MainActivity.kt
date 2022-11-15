package com.example.counter

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var button:Button
    private lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.counter)
        text = findViewById(R.id.value)
        val savedUser = savedInstanceState?.getString("text")
        if (savedUser != null) {
            text.text=savedUser.toString()
        }
        button.setOnClickListener { increment() }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        val num = text.text.toString()
        outState.putString("text",num)
        super.onSaveInstanceState(outState)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val savedUser = savedInstanceState.getString("TEXT")
        if (savedUser != null) {
            Log.d("registered value", savedUser)
        }
    }

    private fun increment(){
        try{
            var temp = Integer.parseInt(text.text as String)
            temp += 1
            text.text= temp.toString()
        }
        catch (e:NumberFormatException ){
            Log.d("TAG", "increment: $e")
        }
    }
}