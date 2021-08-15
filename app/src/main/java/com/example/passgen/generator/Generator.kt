package com.example.passgen.generator

import kotlin.random.Random

class Generator {

    fun createRandomString() : String{
        return (1..length)
            .map{ it -> Random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }

    companion object {
        private lateinit var charPool: MutableList<Char>
        private var length = 0
        private val symbolsList = listOf('.', '@', '*', '$', '#','~','^','+','-','/','?','=')

        fun setOptions(length: Int, options: Options){
            this.length = length
            if(options.upper)
                charPool.addAll('A'..'Z')

            if(options.upper)
                charPool.addAll('a'..'z')

            if(options.numbers)
                charPool.addAll('0'..'9')

            if(options.symbols)
                charPool.addAll(symbolsList)
        }
    }
}

data class Options(
    val upper: Boolean,
    val lower: Boolean,
    val numbers: Boolean,
    val symbols: Boolean
)