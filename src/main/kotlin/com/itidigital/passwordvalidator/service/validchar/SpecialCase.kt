package com.itidigital.passwordvalidator.service.validchar

import com.itidigital.passwordvalidator.model.Password

class SpecialCase : ValidCharStrategy {
    override fun isValid(value: Char): Boolean = value.toString().matches(Regex("[!@#$%^&*()+-]"))

    override fun isValid(password: Password, value: Char) =
        isValid(value).let { if (it) password.special += 1 }
}