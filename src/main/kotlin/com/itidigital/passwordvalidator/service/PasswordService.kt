package com.itidigital.passwordvalidator.service

import com.itidigital.passwordvalidator.model.Password
import com.itidigital.passwordvalidator.service.validchar.DigitCase
import com.itidigital.passwordvalidator.service.validchar.LowerCase
import com.itidigital.passwordvalidator.service.validchar.SpecialCase
import com.itidigital.passwordvalidator.service.validchar.UpperCase
import org.springframework.stereotype.Service

@Service
class PasswordService {

    private val digitCase = DigitCase()
    private val lowerCase = LowerCase()
    private val specialCase = SpecialCase()
    private val upperCase = UpperCase()

    fun checkIfPasswordIsValid(password: Password): Boolean {
        if (!password.checkFirstIfPatternMatches()) return false

        password.password.toCharArray().forEach { c ->

            // check if replacing a character to empty value modifies the string length
            if (password.password.length != password.password.replace(c.toString(), "").length + 1)
                return false

            // validates if there is a match and if there is, increments the requirement
            digitCase.isValid(password, c)
            lowerCase.isValid(password, c)
            specialCase.isValid(password, c)
            upperCase.isValid(password, c)
        }

        return password.isMeetTheRequirements()
    }
}