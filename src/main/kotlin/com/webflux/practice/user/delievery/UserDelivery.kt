package com.webflux.practice.user.delievery

import com.webflux.practice.user.delievery.dto.request.RegisterRequest
import com.webflux.practice.user.delievery.dto.validator.RegisterValidator
import com.webflux.practice.user.usecase.register.RegisterUseCase
import org.springframework.stereotype.Component
import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Errors
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.created
import org.springframework.web.reactive.function.server.awaitBody
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.server.ServerWebInputException
import java.net.URI

@Component
class UserDelivery(
    private val usecase: RegisterUseCase,
) {

    private val validator = RegisterValidator()

    suspend fun register(request: ServerRequest): ServerResponse {
        val requestBody: RegisterRequest = request.awaitBody<RegisterRequest>()
        validate(requestBody)

        usecase.register(requestBody)

        return created(URI("/users"))
            .buildAndAwait()
    }

    private fun validate(request: RegisterRequest) {
        val errors: Errors = BeanPropertyBindingResult(request, "register");

        validator.validate(request, errors)
        if (errors.hasErrors()) {
            throw ServerWebInputException(errors.toString())
        }
    }
}