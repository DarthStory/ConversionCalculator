package com.example.conversioncalculator

import android.util.Log
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import io.mockk.every
import io.mockk.mockkStatic

class ConversionEquationsTest {

    private lateinit var conversionEquations: ConversionEquations

    @Before
    fun setUp() {
        conversionEquations = ConversionEquations()
        mockkStatic(Log::class)
        every {Log.d(any(), any())} returns 0
    }

    // Celsius to Fahrenheit Test
    @Test
    fun testCelsiusToFahrenheit() {
        val result = conversionEquations.celsiusToFahrenheit(0.0)
        assertEquals(32.0, result, 0.01) // Tolerance for floating point comparison
    }

    // Fahrenheit to Celsius Test
    @Test
    fun testFahrenheitToCelsius() {
        val result = conversionEquations.fahrenheitToCelsius(32.0)
        assertEquals(0.0, result, 0.01)
    }

    // Celsius to Kelvin Test
    @Test
    fun testCelsiusToKelvin() {
        val result = conversionEquations.celsiusToKelvin(0.0)
        assertEquals(273.15, result, 0.01)
    }

    // Kelvin to Celsius Test
    @Test
    fun testKelvinToCelsius() {
        val result = conversionEquations.kelvinToCelsius(273.15)
        assertEquals(0.0, result, 0.01)
    }

    // Fahrenheit to Kelvin Test
    @Test
    fun testFahrenheitToKelvin() {
        val result = conversionEquations.fahrenheitToKelvin(32.0)
        assertEquals(273.15, result, 0.01)
    }

    // Kelvin to Fahrenheit Test
    @Test
    fun testKelvinToFahrenheit() {
        val result = conversionEquations.kelvinToFahrenheit(273.15)
        assertEquals(32.0, result, 0.01)
    }
}
