package com.webflux.practice.domain.model.user

import com.webflux.practice.domain.error.errors.UserDuplicatedException
import com.webflux.practice.domain.model.user.entity.User
import com.webflux.practice.domain.model.user.entity.UserRepository
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun findUser(email: String): Mono<User> {
        return userRepository.findById(email)
    }

    fun save(user: User) {
        val resultUser = userRepository.findById(user.email).blockOptional()
        if (resultUser.isPresent) {
            throw UserDuplicatedException()
        }

        userRepository.save(user).subscribe()
    }
}