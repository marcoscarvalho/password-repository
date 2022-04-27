package com.itidigital.passwordvalidator.validchar

import com.itidigital.passwordvalidator.model.Password
import com.itidigital.passwordvalidator.service.validchar.LowerCase
import com.itidigital.passwordvalidator.service.validchar.ValidCharStrategy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class LowerCaseTest {

    private lateinit var implements : ValidCharStrategy

    @Before
    fun setUp() {
        implements = LowerCase()
    }

    @Test
    fun testIfIsValid() {
        assertTrue(implements.isValid('a'))
    }

    @Test
    fun testIfIsNotValid() {
        assertFalse(implements.isValid('A'))
        assertFalse(implements.isValid('-'))
    }

    @Test
    fun testIfIsValid2() {
        val password = Password(password = "aaaa")
        implements.isValid(password, 'a')
        implements.isValid(password, 'b')
        implements.isValid(password, 'c')
        implements.isValid(password, 'A')
        implements.isValid(password, 'B')
        implements.isValid(password, 'C')
        assertEquals(password.lowercase, 3)
    }
}