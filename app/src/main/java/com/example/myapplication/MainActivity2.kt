package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val btn2 = findViewById<Button>(R.id.btn2)
        val twt = findViewById<TextView>(R.id.twt2)
        btn2.setOnClickListener(){
            twt.text="Submit"
        }
    }
}