package com.itidigital.passwordvalidator.model

import java.util.regex.Pattern

data class Password(
    val password: String,
    var uppercase: Int = 0,
    var lowercase: Int = 0,
    var special: Int = 0,
    var digit: Int = 0
) {
    fun checkFirstIfPatternMatches(): Boolean = Pattern.matches("[a-zA-Z0-9!@#$%^&*()+-]{9,}", password)

    fun isMeetTheRequirements(): Boolean = uppercase > 0 && lowercase > 0 && special > 0 && digit > 0

}