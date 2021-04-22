package com.webflux.practice.global.security.jwt

import com.auth0.jwt.interfaces.DecodedJWT
import com.webflux.practice.domain.error.errors.UnauthorizedException
import org.springframework.security.core.Authentication
import reactor.core.publisher.Mono
import java.lang.Exception

object CurrentUserAuthenticationBearer {
    fun create(decodedJWT: DecodedJWT): Mono<Authentication> {
        val type: String
        val email: String
        try {
            type = decodedJWT.claims["type"]!!.asString()
            email = decodedJWT.claims["userId"]!!.asString()
        } catch (e: Exception) {
            throw UnauthorizedException()
        }
        return Mono.justOrEmpty(UserToken(type, email, decodedJWT))
    }
}