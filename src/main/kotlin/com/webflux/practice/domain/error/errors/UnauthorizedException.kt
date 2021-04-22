package com.webflux.practice.domain.error.errors

import com.webflux.practice.domain.error.BusinessException
import org.springframework.http.HttpStatus

class UnauthorizedException : BusinessException(HttpStatus.CONFLICT, "Unauthorized.") {
}