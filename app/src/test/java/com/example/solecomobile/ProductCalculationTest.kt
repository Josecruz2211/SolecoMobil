package com.example.solecomobile

import org.junit.Assert.assertEquals
import org.junit.Test

class ProductCalculationTest {

    private fun calculateTotal(price: Double, quantity: Int): Double {
        return price * quantity
    }

    @Test
    fun testCalculateOrderTotal() {
        val unitPrice = 25000.0 // Precio del desinfectante
        val quantity = 3       // Cantidad solicitada por el cliente
        val expectedTotal = 75000.0

        val actualTotal = calculateTotal(unitPrice, quantity)

        // Validar que el cálculo matemático sea exacto
        assertEquals(expectedTotal, actualTotal, 0.001)
    }
}