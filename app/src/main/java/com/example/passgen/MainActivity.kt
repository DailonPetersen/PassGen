package com.example.passgen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.passgen.generator.Generator
import com.example.passgen.ui.FormFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fm = supportFragmentManager
        fm.beginTransaction().add(FormFragment(), "form_fragment").commit()

    }

}