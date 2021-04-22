package com.webflux.practice.domain.error

import org.springframework.http.HttpStatus

open class BusinessException(private val status: HttpStatus, message: String) : RuntimeException(message) {
    fun getStatus(): HttpStatus {
        return status
    }
}