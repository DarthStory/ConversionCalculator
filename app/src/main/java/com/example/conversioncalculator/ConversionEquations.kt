package com.example.conversioncalculator

import android.util.Log

class ConversionEquations {

    // Celsius to Fahrenheit
    fun celsiusToFahrenheit(celsius: Double): Double {
        Log.d("ConversionUtils", "Converting $celsius°C to Fahrenheit")
        return (celsius * 9 / 5) + 32
    }

    // Fahrenheit to Celsius
    fun fahrenheitToCelsius(fahrenheit: Double): Double {
        Log.d("ConversionUtils", "Converting $fahrenheit°F to Celsius")
        return (fahrenheit - 32) * 5 / 9
    }

    // Celsius to Kelvin
    fun celsiusToKelvin(celsius: Double): Double {
        Log.d("ConversionUtils", "Converting $celsius°C to Kelvin")
        return celsius + 273.15
    }

    // Kelvin to Celsius
    fun kelvinToCelsius(kelvin: Double): Double {
        Log.d("ConversionUtils", "Converting $kelvin K to Celsius")
        return kelvin - 273.15
    }

    // Fahrenheit to Kelvin
    fun fahrenheitToKelvin(fahrenheit: Double): Double {
        Log.d("ConversionUtils", "Converting $fahrenheit°F to Kelvin")
        return (fahrenheit - 32) * 5 / 9 + 273.15
    }

    // Kelvin to Fahrenheit
    fun kelvinToFahrenheit(kelvin: Double): Double {
        Log.d("ConversionUtils", "Converting $kelvin K to Fahrenheit")
        return (kelvin - 273.15) * 9 / 5 + 32
    }

}