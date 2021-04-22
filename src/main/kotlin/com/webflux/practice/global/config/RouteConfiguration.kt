package com.webflux.practice.global.config

import com.webflux.practice.user.delivery.UserDelivery
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class RouteConfiguration {
    @Bean
    fun mainRouter(userDelivery: UserDelivery) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            POST("/auth", )
            POST("/user", userDelivery::register)
        }
    }
}