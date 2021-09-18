package com.example.passgen.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.passgen.generator.Generator
import com.example.passgen.generator.Options

class GeneratorViewModel : ViewModel() {

    val passwordGenerated = MutableLiveData<String>()

    fun generate(length: Int, upper: Boolean, lower: Boolean, numbers: Boolean, symbols: Boolean){

        val optionsReceived = Options(upper, lower, numbers, symbols)

        Generator.setOptions(length, optionsReceived)

        passwordGenerated.value = Generator().createRandomString()
    }
}