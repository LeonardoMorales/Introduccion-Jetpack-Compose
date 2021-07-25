package com.dev.leonardom.introuduccionajetpackcompose.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import com.dev.leonardom.introuduccionajetpackcompose.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*setContent {
            Text(text = "Nuevo Componible")
        }*/
        setContentView(R.layout.activity_second)
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, PrimerFragmento())
            commit()
        }
    }
}