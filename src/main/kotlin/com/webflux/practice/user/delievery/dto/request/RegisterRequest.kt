package com.webflux.practice.user.delievery.dto.request

data class RegisterRequest(
    val email: String, val password: String, val name: String
)