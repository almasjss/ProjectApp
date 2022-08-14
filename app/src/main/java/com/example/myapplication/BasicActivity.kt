package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class BasicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic)
        val btnMusic = findViewById<ImageButton>(R.id.MusicButton)
        val btnFilm = findViewById<ImageButton>(R.id.FilmButton)
        toast("Главное меню")
        btnFilm.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java )
            startActivity(intent)
        }
        btnMusic.setOnClickListener {
            val intent = Intent(this,MusicActivity::class.java)
            startActivity(intent)
        }
    }
}
fun  Context.toast(message: CharSequence){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}