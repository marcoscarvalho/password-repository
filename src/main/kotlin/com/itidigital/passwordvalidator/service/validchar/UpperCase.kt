package com.itidigital.passwordvalidator.service.validchar

import com.itidigital.passwordvalidator.model.Password

class UpperCase : ValidCharStrategy {
    override fun isValid(value: Char): Boolean = value.toString().matches(Regex("[A-Z]"))

    override fun isValid(password: Password, value: Char) =
        value.toString().matches(Regex("[A-Z]")).let { if (it) password.uppercase += 1 }
}