package com.webflux.practice.user.usecase.register

import com.webflux.practice.user.delivery.dto.request.RegisterRequest

interface RegisterUseCase {
    suspend fun register(request: RegisterRequest)
}