package com.itidigital.passwordvalidator.service.validchar

import com.itidigital.passwordvalidator.model.Password

class DigitCase : ValidCharStrategy {
    override fun isValid(value: Char): Boolean = value.toString().matches(Regex("[0-9]"))

    override fun isValid(password: Password, value: Char) =
        isValid(value).let { if (it) password.digit += 1 }
}