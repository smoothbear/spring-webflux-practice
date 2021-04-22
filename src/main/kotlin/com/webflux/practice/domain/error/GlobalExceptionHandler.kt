package com.webflux.practice.domain.error

import com.webflux.practice.global.log.Logger
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.support.WebExchangeBindException
import org.springframework.web.server.ServerWebExchange
import java.lang.RuntimeException

@ControllerAdvice
class GlobalExceptionHandler {
    companion object: Logger

    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(bex: BusinessException, exchange: ServerWebExchange): ResponseEntity<ErrorResponse> {
        val status = bex.getStatus()
        val message = bex.message ?: ""

        logger.error("[BusinessException] status code: $status\n message: $message")

        return ResponseEntity<ErrorResponse>(
            ErrorResponse(
                timestamp = System.currentTimeMillis(),
                status = status.value(),
                message = message,
            ), status
        )
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntimeException(rex: RuntimeException, exchange: ServerWebExchange): ResponseEntity<ErrorResponse> {
        val status = HttpStatus.INTERNAL_SERVER_ERROR
        val message = rex.message ?: ""

        logger.error("[RuntimeException] status code: $status\n message: $message")

        return ResponseEntity<ErrorResponse>(
            ErrorResponse(
                timestamp = System.currentTimeMillis(),
                status = status.value(),
                message = message,
            ), status
        )
    }

    @ExceptionHandler(WebExchangeBindException::class)
    fun handleRuntimeException(wex: WebExchangeBindException, exchange: ServerWebExchange): ResponseEntity<ErrorResponse> {
        val status = wex.status
        val message = wex.message

        logger.error("[WebExchangeBindException] status code: $status\n message: $message")

        return ResponseEntity<ErrorResponse>(
            ErrorResponse(
                timestamp = System.currentTimeMillis(),
                status = status.value(),
                message = message,
            ), status
        )
    }
}