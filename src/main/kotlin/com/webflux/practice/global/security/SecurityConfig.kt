package com.webflux.practice.global.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {
    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http
            .httpBasic().disable()
            .formLogin().disable()
            .logout().disable()

            .authorizeExchange().pathMatchers(HttpMethod.GET, "/video").permitAll().and()
            .authorizeExchange().pathMatchers(HttpMethod.POST, "/auth").permitAll().and()
            .authorizeExchange().pathMatchers(HttpMethod.POST, "/user").permitAll().and()

            .authorizeExchange()
            .pathMatchers("/**").authenticated().and()


        return http.build()
    }
}