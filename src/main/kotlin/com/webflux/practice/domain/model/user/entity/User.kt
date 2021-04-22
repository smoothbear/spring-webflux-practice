package com.webflux.practice.domain.model.user.entity

import org.springframework.data.annotation.Id

open class User(
    @Id
    val email: String,

    val password: String,

    val name: String,
)