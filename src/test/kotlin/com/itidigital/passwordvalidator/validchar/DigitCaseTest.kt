package com.itidigital.passwordvalidator.validchar

import com.itidigital.passwordvalidator.service.validchar.DigitCase
import com.itidigital.passwordvalidator.service.validchar.ValidCharStrategy
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class DigitCaseTest {

    private lateinit var implements: ValidCharStrategy

    @Before
    fun setUp() {
        implements = DigitCase()
    }

    @Test
    fun testIfIsValid() {
        assertTrue(implements.isValid('1'))
        assertTrue(implements.isValid('2'))
        assertTrue(implements.isValid('3'))
        assertTrue(implements.isValid('4'))
        assertTrue(implements.isValid('5'))
        assertTrue(implements.isValid('6'))
        assertTrue(implements.isValid('7'))
        assertTrue(implements.isValid('8'))
        assertTrue(implements.isValid('9'))
        assertTrue(implements.isValid('0'))
    }

    @Test
    fun testIfIsNotValid() {
        assertFalse(implements.isValid('a'))
        assertFalse(implements.isValid('-'))
    }
}