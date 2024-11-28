package com.lucavado.wolfttexx.menuprimary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.lucavado.wolfttexx.MainActivity
import com.lucavado.wolfttexx.R
import com.lucavado.wolfttexx.imccalculatorapp.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnFirst = findViewById<Button>(R.id.btnFirst)
        val btnSecond = findViewById<Button>(R.id.btnSecond)
        btnFirst.setOnClickListener { navigateToSaludApp() }
        btnSecond.setOnClickListener { navigateToImcApp() }
    }


    //    Methods to navigate to other activities
    private fun navigateToSaludApp() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }
}