package com.webflux.practice.global.security.jwt

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.interfaces.DecodedJWT
import com.webflux.practice.domain.error.errors.UnauthorizedException
import org.springframework.beans.factory.annotation.Value
import reactor.core.publisher.Mono

class JwtVerifyHandler(
    private val secretKey: String
) {

    fun check(accessToken: String): Mono<DecodedJWT> = Mono.just(
        JWT.require(Algorithm.HMAC256(secretKey)).build().verify(accessToken)
    ).log()
}