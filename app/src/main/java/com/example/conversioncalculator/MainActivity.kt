package com.example.conversioncalculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.conversioncalculator.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val conversionEquations = ConversionEquations() // Create an instance
    private var inputUnit: String = ""  // To track the input unit (Celsius, Fahrenheit, Kelvin)
    private var outputUnit: String = "" // To track the output unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
    }

    private fun setupListeners() {
        val selectedColor = getColor(R.color.buttonSelected)

        // Input Unit Buttons
        binding.celsiusIn.setOnClickListener {
            inputUnit = getString(R.string.celsius)
            binding.tempScale.text = inputUnit
            resetButtonColors() // Reset other buttons
            binding.celsiusIn.setBackgroundColor(selectedColor) // Highlight selected button
            Toast.makeText(this, "Input Unit: $inputUnit", Toast.LENGTH_SHORT).show()
        }
        binding.fahrenheitIn.setOnClickListener {
            inputUnit = getString(R.string.fahrenheit)
            binding.tempScale.text = inputUnit
            resetButtonColors()
            binding.fahrenheitIn.setBackgroundColor(selectedColor)
            Toast.makeText(this, "Input Unit: $inputUnit", Toast.LENGTH_SHORT).show()
        }
        binding.kelvinIn.setOnClickListener {
            inputUnit = getString(R.string.kelvin)
            binding.tempScale.text = inputUnit
            resetButtonColors()
            binding.kelvinIn.setBackgroundColor(selectedColor)
            Toast.makeText(this, "Input Unit: $inputUnit", Toast.LENGTH_SHORT).show()
        }

        // Output Unit Buttons
        binding.celsiusOut.setOnClickListener {
            outputUnit = getString(R.string.celsius)
            binding.tempScale2.text = outputUnit
            resetButtonColors()
            binding.celsiusOut.setBackgroundColor(selectedColor)
            Toast.makeText(this, "Output Unit: $outputUnit", Toast.LENGTH_SHORT).show()
        }
        binding.fahrenheitOut.setOnClickListener {
            outputUnit = getString(R.string.fahrenheit)
            binding.tempScale2.text = outputUnit
            resetButtonColors()
            binding.fahrenheitOut.setBackgroundColor(selectedColor)
            Toast.makeText(this, "Output Unit: $outputUnit", Toast.LENGTH_SHORT).show()
        }
        binding.kelvinOut.setOnClickListener {
            outputUnit = getString(R.string.kelvin)
            binding.tempScale2.text = outputUnit
            resetButtonColors()
            binding.kelvinOut.setBackgroundColor(selectedColor)
            Toast.makeText(this, "Output Unit: $outputUnit", Toast.LENGTH_SHORT).show()
        }

        // Convert Button
        binding.convertButton.setOnClickListener {
            performConversion()
        }
    }

    private fun resetButtonColors() {
        val defaultColor = getColor(R.color.buttonDefault)
        // Reset all button colors to default
        binding.celsiusIn.setBackgroundColor(defaultColor)
        binding.fahrenheitIn.setBackgroundColor(defaultColor)
        binding.kelvinIn.setBackgroundColor(defaultColor)
        binding.celsiusOut.setBackgroundColor(defaultColor)
        binding.fahrenheitOut.setBackgroundColor(defaultColor)
        binding.kelvinOut.setBackgroundColor(defaultColor)
    }




    private fun performConversion() {
        val inputValue = binding.degreesIn.text.toString().toDoubleOrNull()

        if (inputValue == null) {
            Toast.makeText(this, "Please enter a valid number!", Toast.LENGTH_SHORT).show()
            return
        }

        if (inputUnit.isEmpty() || outputUnit.isEmpty()) {
            Toast.makeText(this, "Please select both input and output units!", Toast.LENGTH_SHORT).show()
            return
        }

        val result = convertTemperature(inputValue, inputUnit, outputUnit)

        // Fix: Format with Locale for proper number formatting (US locale is 1.5, French locale is 1,5)
        val formattedResult = String.format(Locale.getDefault(), "%.2f", result)
        binding.degreesOut.setText(formattedResult)
        Log.d("MainActivity", "Converted $inputValue $inputUnit to $formattedResult $outputUnit")
    }

    private fun convertTemperature(value: Double, fromUnit: String, toUnit: String): Double {
        return when (fromUnit to toUnit) {
            "Celsius" to "Fahrenheit" -> conversionEquations.celsiusToFahrenheit(value)
            "Celsius" to "Kelvin" -> conversionEquations.celsiusToKelvin(value)
            "Fahrenheit" to "Celsius" -> conversionEquations.fahrenheitToCelsius(value)
            "Fahrenheit" to "Kelvin" -> conversionEquations.fahrenheitToKelvin(value)
            "Kelvin" to "Celsius" -> conversionEquations.kelvinToCelsius(value)
            "Kelvin" to "Fahrenheit" -> conversionEquations.kelvinToFahrenheit(value)
            else -> value // No conversion needed if the same unit is selected
        }
    }
}
