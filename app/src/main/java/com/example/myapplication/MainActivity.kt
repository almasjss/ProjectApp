package com.example.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.app

class MainActivity : AppCompatActivity() {
    lateinit var eTemail: EditText
    lateinit var eTpassword: EditText

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn1)
        val eTemail = findViewById<EditText>(R.id.email)
        var eTpassword = findViewById<EditText>(R.id.password)
        val valid = findViewById<TextView>(R.id.validation)

        btn.setOnClickListener {
            signUpUser()
        }
    }

    fun Context.success(message: CharSequence) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun signUpUser() {
        val email = eTemail.text.toString()
        val pass = eTpassword.text.toString()

        if (email.isBlank() || pass.isBlank()) {
            success("Email and Password is the blank")
            return
        }
        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                success("Успешно прошел логин!")
            } else {
                success("Ошибка при регестрации!")
            }
        }
    }

}