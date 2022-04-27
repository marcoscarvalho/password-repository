package com.itidigital.passwordvalidator.service.validchar

import com.itidigital.passwordvalidator.model.Password

interface ValidCharStrategy {
    fun isValid(value: Char): Boolean

    fun isValid(password: Password, value: Char)
}