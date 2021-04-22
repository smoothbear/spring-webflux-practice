package com.webflux.practice.global.security.jwt

import com.auth0.jwt.interfaces.DecodedJWT
import org.springframework.security.authentication.AbstractAuthenticationToken

class UserToken(
    private val tokenType: String,
    private val email: String,
    private val decodedJwtToken: DecodedJWT,
) : AbstractAuthenticationToken(null) {

    override fun getCredentials(): Any {
        return this.decodedJwtToken
    }

    override fun getPrincipal(): Any {
        return this.email
    }
}