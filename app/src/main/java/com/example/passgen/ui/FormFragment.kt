package com.example.passgen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.passgen.R
import kotlinx.android.synthetic.main.form_fragment.*

class FormFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.form_fragment, container, false)
        return view
    }

    fun generate(){
        generate_btn
    }

}