package com.webflux.practice.auth.usecase.login

import com.webflux.practice.auth.delivery.dto.request.LoginRequest
import com.webflux.practice.auth.delivery.dto.response.LoginResponse

interface LoginUseCase {
    suspend fun login(request: LoginRequest): LoginResponse
}