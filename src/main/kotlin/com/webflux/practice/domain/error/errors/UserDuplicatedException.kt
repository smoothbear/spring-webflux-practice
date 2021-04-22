package com.webflux.practice.domain.error.errors

import com.webflux.practice.domain.error.BusinessException
import org.springframework.http.HttpStatus

class UserDuplicatedException : BusinessException(HttpStatus.CONFLICT, "user is already exist.") {
}