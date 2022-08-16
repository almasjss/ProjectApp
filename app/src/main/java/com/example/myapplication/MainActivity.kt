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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn1)
        val eTemail = findViewById<EditText>(R.id.email)
        var eTpassword = findViewById<EditText>(R.id.password)
        auth = FirebaseAuth.getInstance()
        btn.setOnClickListener {
            registerUser(eTemail, eTpassword)
        }
    }

    private fun registerUser(eTemail: EditText?, eTpassword: EditText?) {
        val email = eTemail?.text.toString()
        val pass = eTpassword?.text.toString()
        if (email!=null ) {
            auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(MainActivity()) { task ->
                    if (task.isSuccessful) {
                        success("Успешно прошел логин!")
                        startActivity(Intent(this, BasicActivity::class.java))
                        finish()
                    } else {
                        success("Error! Login")
                        startActivity(Intent(this, BasicActivity::class.java))
                    }
                }

        } else {
            success("Error because is null!")
        }
    }

    fun Context.success(message: CharSequence) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

