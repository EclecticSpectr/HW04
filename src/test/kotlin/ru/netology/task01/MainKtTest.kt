package ru.netology.task01

import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun commissionCalculateVisa() {
        val cardType = "Visa"
        val pastTransfers = 499_999.0
        val currentTransfer = 75_001.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(562.5075, result, 0.001)
    }

    @Test
    fun commissionCalculateVKPay() {
        val cardType = "VK Pay"
        val pastTransfers = 5_999.0
        val currentTransfer = 10_001.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun commissionCalculateLimitVKPay() {
        val cardType = "VK Pay"
        val pastTransfers = 14_999.0
        val currentTransfer = 15_001.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(-1.0, result, 0.0)
    }

    @Test
    fun commissionCalculateLimitMaestro() {
        val cardType = "Maestro"
        val pastTransfers = 14_999.0
        val currentTransfer = 150_001.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(-1.0, result, 0.0)
    }

    @Test
    fun commissionCalculateVisaLowTax() {
        val cardType = "Visa"
        val pastTransfers = 14_999.0
        val currentTransfer = 100.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(35.0, result, 0.0)
    }

    @Test
    fun commissionCalculateVisaLowTransfer() {
        val cardType = "Visa"
        val pastTransfers = 14_999.0
        val currentTransfer = 34.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(-1.0, result, 0.0)
    }

    @Test
    fun commissionCalculateMaestroZero() {
        val cardType = "Maestro"
        val pastTransfers = 14_999.0
        val currentTransfer = 100.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun commissionCalculateMastercard() {
        val cardType = "Mastercard"
        val pastTransfers = 499_999.0
        val currentTransfer = 75_001.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(470.006, result, 0.001)
    }

    @Test
    fun commissionCalculatePeaceNotCheckLimits() {
        val cardType = "Мир"
        val pastTransfers = 700_999.0
        val currentTransfer = 200_000.0

        val result = commissionCalculate(cardType, pastTransfers, currentTransfer)

        assertEquals(-1.0, result, 0.0)
    }
}