package com.example.diceroller

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun generates_number() {
        val testDice = Dice(6)
        val diceValue = testDice.roll()
        assertTrue("The value of rollResult was not between 1 and 6",
            diceValue in 1..6)
    }
    }
