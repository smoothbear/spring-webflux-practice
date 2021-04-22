package com.webflux.practice.domain.error

data class ErrorResponse(
    private val timestamp: Long,
    private val status: Number,
    private val message: String,
)