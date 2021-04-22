package com.webflux.practice.domain.model.user.entity

import org.springframework.data.r2dbc.repository.R2dbcRepository

interface UserRepository : R2dbcRepository<User, String> {
}