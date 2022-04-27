package com.itidigital.passwordvalidator

import com.itidigital.passwordvalidator.model.Password
import com.itidigital.passwordvalidator.service.PasswordService
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
class PasswordServiceTest {

    private lateinit var passwordService: PasswordService

    @Before
    fun setUp() {
        passwordService = PasswordService()
    }

    @Test
    fun `check if password is valid`() {
        assertTrue(passwordService.checkIfPasswordIsValid(Password(password = "AbTp9!fok")))
        assertTrue(passwordService.checkIfPasswordIsValid(Password(password = "AbTp9-fok")))
    }

    @Test
    fun `check if password is not valid`() {
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "aa")))
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "aba")))
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "")))
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "ab")))
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "AAAbbbCc")))
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "AbTp9!foo")))
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "AbTp9!foA")))
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "AbTp9 fok")))
        assertFalse(passwordService.checkIfPasswordIsValid(Password(password = "AbTp9_fok")))
    }
}