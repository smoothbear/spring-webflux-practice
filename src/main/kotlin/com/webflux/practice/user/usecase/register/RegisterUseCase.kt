package com.webflux.practice.user.usecase.register

import com.webflux.practice.user.delievery.dto.request.RegisterRequest

interface RegisterUseCase {
    suspend fun register(request: RegisterRequest)
}