package com.itidigital.passwordvalidator.service.validchar

import com.itidigital.passwordvalidator.model.Password

class LowerCase : ValidCharStrategy {
    override fun isValid(value: Char): Boolean = value.toString().matches(Regex("[a-z]"))

    override fun isValid(password: Password, value: Char) =
        isValid(value).let { if (it) password.lowercase += 1 }
}