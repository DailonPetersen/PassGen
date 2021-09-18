package com.example.passgen.view

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityService.SHOW_MODE_HIDDEN
import android.accessibilityservice.AccessibilityService.SoftKeyboardController
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.passgen.databinding.FormFragmentBinding
import com.example.passgen.viewmodel.GeneratorViewModel

class FormFragment : Fragment(), View.OnFocusChangeListener {

    private var _binding: FormFragmentBinding? = null
    private val bindingForm get() = _binding!!
    private val model: GeneratorViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FormFragmentBinding.inflate(inflater, container, false)
        return bindingForm.root
    }

    private var upper: Boolean = false
    private var lower: Boolean = false
    private var numbers: Boolean = false
    private var symbols: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun onSelectBox(button: CompoundButton?) {
            if ( button != null ) {
                when (button.id) {
                    bindingForm.checkboxUppercase.id -> {
                        upper = true
                    }
                    bindingForm.checkboxLowercase.id -> {
                        lower = true
                    }
                    bindingForm.checkboxNumbers.id -> {
                        numbers = true
                    }
                    bindingForm.checkboxSymbols.id -> {
                        symbols = true
                    }
                }
            }
        }

        bindingForm.checkboxUppercase.setOnCheckedChangeListener { compoundButton, _ -> onSelectBox(compoundButton) }
        bindingForm.checkboxLowercase.setOnCheckedChangeListener { compoundButton, _ -> onSelectBox(compoundButton) }
        bindingForm.checkboxNumbers.setOnCheckedChangeListener { compoundButton, _ -> onSelectBox(compoundButton) }
        bindingForm.checkboxSymbols.setOnCheckedChangeListener { compoundButton, _ -> onSelectBox(compoundButton) }

        bindingForm.generateBtn.setOnClickListener {
            val length = bindingForm.lenghtField.text.toString()
            model.generate(length.toInt(), upper, lower, numbers, symbols)
        }

        bindingForm.display.doOnTextChanged { _, _, _, _ ->
            bindingForm.display.letterSpacing = Float.fromBits(0)
        }

        bindingForm.cleanBtn.setOnClickListener { cleanAll() }

        model.passwordGenerated.observe(viewLifecycleOwner, {
            bindingForm.display.text = it
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onFocusChange(view: View?, hasFocus: Boolean) {
        if(hasFocus){
            view?.let {
                if(!it.id.equals(bindingForm.lenghtField) && bindingForm.lenghtField.isInEditMode){
                    bindingForm.lenghtField.clearFocus()
                }
            }
        }
    }

    private fun cleanAll() {
        bindingForm.checkboxLowercase.isChecked = false
        bindingForm.checkboxUppercase.isChecked = false
        bindingForm.checkboxNumbers.isChecked = false
        bindingForm.checkboxSymbols.isChecked = false
        bindingForm.lenghtField.text?.clear()
        bindingForm.display.text = ""
    }
}