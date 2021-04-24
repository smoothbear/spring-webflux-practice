package com.webflux.practice.auth.delivery

import com.webflux.practice.auth.delivery.dto.request.ChangePasswordRequest
import com.webflux.practice.auth.delivery.dto.request.LoginRequest
import com.webflux.practice.auth.usecase.login.LoginUseCase
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Component
class AuthDelivery(
    private val loginUseCase: LoginUseCase
) {
    suspend fun login(request: ServerRequest): ServerResponse {
        val requestBody = request.awaitBody<LoginRequest>()
        val responseBody = loginUseCase.login(requestBody)

        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(responseBody)
    }

    suspend fun changePassword(request: ServerRequest): ServerResponse {
        val requestBody = request.awaitBody<ChangePasswordRequest>()

        return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .buildAndAwait()
    }
}