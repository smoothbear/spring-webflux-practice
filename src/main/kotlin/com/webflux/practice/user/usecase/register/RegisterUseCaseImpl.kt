package com.webflux.practice.user.usecase.register

import com.webflux.practice.global.log.Logger
import com.webflux.practice.user.delievery.dto.request.RegisterRequest
import com.webflux.practice.domain.model.user.entity.User
import com.webflux.practice.domain.model.user.UserFacade
import org.springframework.stereotype.Service

@Service
class RegisterUseCaseImpl(private val userFactory: UserFacade) : RegisterUseCase {
    companion object: Logger

    override suspend fun register(request: RegisterRequest) {
        userFactory.save(
            User(
                email = request.email,
                password = request.password,
                name = request.name,
            )
        )

        logger.info("User has been created. email: ${request.email}")
    }
}