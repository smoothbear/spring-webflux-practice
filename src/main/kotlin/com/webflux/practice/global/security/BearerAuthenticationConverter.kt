package com.webflux.practice.global.security

import com.auth0.jwt.JWTVerifier
import com.webflux.practice.global.security.jwt.JwtVerifyHandler
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.security.core.Authentication
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import java.util.function.Function

class BearerAuthenticationConverter : Function<ServerWebExchange, Mono<Authentication>> {
    @Value("#{auth.jwt.secret}")
    lateinit var secretKey: String

    override fun apply(t: ServerWebExchange): Mono<Authentication> {
        val jwtVerifier = JwtVerifyHandler(secretKey)

        return Mono.justOrEmpty(t)
            .flatMap{ _ -> Mono.justOrEmpty(t.request.headers.getFirst(HttpHeaders.AUTHORIZATION))}
            .filter{ authValue -> authValue.length > 7 }
            .flatMap { authValue -> Mono.justOrEmpty(authValue.substring(7)) }
            .flatMap (jwtVerifier::check)
            .flatMap { C }
    }
}