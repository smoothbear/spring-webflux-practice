package com.webflux.practice.user.delivery.dto.request

data class RegisterRequest(
    val email: String, val password: String, val name: String
)