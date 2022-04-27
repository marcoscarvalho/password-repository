package com.itidigital.passwordvalidator.router

import com.itidigital.passwordvalidator.handlers.PasswordHandler
import com.itidigital.passwordvalidator.model.PasswordRequest
import com.itidigital.passwordvalidator.model.PasswordResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.parameters.RequestBody
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class PasswordRouter {

    @RouterOperations(
        RouterOperation(
            path = "/v1/api/password/validator",
            method = [RequestMethod.POST],
            operation = Operation(
                operationId = "check-if-password-is-valid",
                requestBody = RequestBody(
                    content = [Content(schema = Schema(implementation = PasswordRequest::class))]
                ),
                responses = [
                    ApiResponse(
                        responseCode = "200",
                        content = [Content(schema = Schema(implementation = PasswordResponse::class))]
                    )
                ]
            )
        )
    )
    @Bean
    fun passwordRoutes(passwordHandler: PasswordHandler) = coRouter {
        POST("/v1/api/password/validator", passwordHandler::checkIfPasswordIsValid)
    }
}