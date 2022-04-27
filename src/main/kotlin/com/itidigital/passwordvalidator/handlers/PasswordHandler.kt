package com.itidigital.passwordvalidator.handlers

import com.itidigital.passwordvalidator.model.Password
import com.itidigital.passwordvalidator.model.PasswordRequest
import com.itidigital.passwordvalidator.model.PasswordResponse
import com.itidigital.passwordvalidator.service.PasswordService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class PasswordHandler(
    private val passwordService: PasswordService
) {

    suspend fun checkIfPasswordIsValid(request: ServerRequest): ServerResponse {
        val passwordRequest = request.awaitBodyOrNull(PasswordRequest::class)
            ?: return ServerResponse.badRequest().buildAndAwait()

        return ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(
                PasswordResponse(
                    passwordService.checkIfPasswordIsValid(Password(passwordRequest.password))
                )
            )
    }
}