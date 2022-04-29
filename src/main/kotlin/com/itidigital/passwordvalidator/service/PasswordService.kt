package com.itidigital.passwordvalidator.service

import com.itidigital.passwordvalidator.model.Password
import com.itidigital.passwordvalidator.service.validchar.*
import org.springframework.stereotype.Service

@Service
class PasswordService(
    private val listOfValidChar : List<ValidCharStrategy>
) {

    fun checkIfPasswordIsValid(password: Password): Boolean {
        if (!password.checkFirstIfPatternMatches()) return false

        password.password.toCharArray().forEach { c ->

            // check if replacing a character to empty value modifies the string length
            if (password.password.length != password.password.replace(c.toString(), "").length + 1)
                return false

            // validates if there is a match and if there is, increments the requirement
            listOfValidChar.forEach{validChar -> validChar.isValid(password, c) }
        }

        return password.isMeetTheRequirements()
    }
}