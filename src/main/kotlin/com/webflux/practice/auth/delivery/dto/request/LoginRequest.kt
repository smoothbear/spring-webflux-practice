package com.webflux.practice.auth.delivery.dto.request

data class LoginRequest (
    private val email: String,
    private val password: String
)