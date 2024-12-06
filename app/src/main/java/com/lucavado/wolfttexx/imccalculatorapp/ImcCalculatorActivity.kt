package com.lucavado.wolfttexx.imccalculatorapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.slider.RangeSlider
import com.lucavado.wolfttexx.R

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    private lateinit var rsHeight: RangeSlider
    private lateinit var tvHeight: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator_acivity)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setGenderColor()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.cardMale)
        viewFemale = findViewById(R.id.cardFemale)
        rsHeight = findViewById(R.id.rangeSlider1)
        tvHeight = findViewById(R.id.heightValue)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender(clickedOnMale = true)
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender(clickedOnMale = false)
            setGenderColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = java.text.DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
    }


    private fun changeGender(clickedOnMale: Boolean) {
        if (clickedOnMale && !isMaleSelected) {
            isMaleSelected = true
            isFemaleSelected = false
        } else if (!clickedOnMale && !isFemaleSelected) {
            isMaleSelected = false
            isFemaleSelected = true
        }
    }


    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }
        return ContextCompat.getColor(this, colorReference)
    }
}
