package com.example.passgen

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import com.example.passgen.databinding.ActivityMainBinding
import com.example.passgen.view.FormFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fm = supportFragmentManager
        fm.beginTransaction().replace(R.id.fragmentContainer, FormFragment(), "form_fragment").commit()
    }

}