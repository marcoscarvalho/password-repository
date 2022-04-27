package com.itidigital.passwordvalidator

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@OpenAPIDefinition(info = Info(
    title = "password-validator",
    version = "1.0.0",
    description = "For this challenge, you should use /v1/api/password/validator to test API."))
class PasswordValidatorApplication {}

fun main(args: Array<String>) {
    runApplication<PasswordValidatorApplication>(*args)
}


