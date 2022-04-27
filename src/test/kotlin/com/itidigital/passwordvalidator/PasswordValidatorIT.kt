package com.itidigital.passwordvalidator

import com.itidigital.passwordvalidator.model.PasswordRequest
import com.itidigital.passwordvalidator.model.PasswordResponse
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBodyList
import org.springframework.web.reactive.function.BodyInserters

@SpringBootTest
@AutoConfigureWebTestClient
class PasswordValidatorIT(
    @Autowired val client: WebTestClient
) {

    @Test
    fun `call api should return 200 and result true`() {
        client
            .post()
            .uri("/v1/api/password/validator")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(PasswordRequest("AbTp9!fok"))
            .exchange()
            .expectStatus()
            .isOk
            .expectBody()
            .jsonPath("result")
            .isEqualTo("true")
    }

    @Test
    fun `call api should return 200 and result false`() {
        client
            .post()
            .uri("/v1/api/password/validator")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(PasswordRequest("AbTp9 fok!fok"))
            .exchange()
            .expectStatus()
            .isOk
            .expectBody()
            .jsonPath("result")
            .isEqualTo("false")
    }

    @Test
    fun `call api should return 400`() {
        client
            .post()
            .uri("/v1/api/password/validator")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(BodyInserters.fromValue("{}"))
            .exchange()
            .expectStatus()
            .isBadRequest
    }

}
