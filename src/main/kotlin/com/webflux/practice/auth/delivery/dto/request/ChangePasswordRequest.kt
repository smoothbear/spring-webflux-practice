package com.webflux.practice.auth.delivery.dto.request

data class ChangePasswordRequest(
    private val prePassword: String,
    private val curPassword: String
)