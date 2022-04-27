package com.itidigital.passwordvalidator.validchar

import com.itidigital.passwordvalidator.service.validchar.SpecialCase
import com.itidigital.passwordvalidator.service.validchar.ValidCharStrategy
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class SpecialCaseTest {

    private lateinit var implements: ValidCharStrategy

    @Before
    fun setUp() {
        implements = SpecialCase()
    }

    @Test
    fun testIfIsValid() {
        assertTrue(implements.isValid('!'))
        assertTrue(implements.isValid('@'))
        assertTrue(implements.isValid('#'))
        assertTrue(implements.isValid('$'))
        assertTrue(implements.isValid('%'))
        assertTrue(implements.isValid('^'))
        assertTrue(implements.isValid('&'))
        assertTrue(implements.isValid('*'))
        assertTrue(implements.isValid('('))
        assertTrue(implements.isValid(')'))
        assertTrue(implements.isValid('+'))
        assertTrue(implements.isValid('-'))
    }

    @Test
    fun testIfIsNotValid() {
        assertFalse(implements.isValid('_'))
    }
}