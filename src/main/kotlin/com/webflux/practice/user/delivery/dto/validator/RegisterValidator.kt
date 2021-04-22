package com.webflux.practice.user.delievery.dto.validator

import com.webflux.practice.user.delievery.dto.request.RegisterRequest
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils
import org.springframework.validation.Validator

class RegisterValidator : Validator {
    override fun supports(clazz: Class<*>): Boolean {
        return RegisterRequest::class.java == clazz
    }

    override fun validate(target: Any, errors: Errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "[EMPTY]:email")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "[EMPTY]:password")
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "[EMPTY]:name")

        val p = target as RegisterRequest

        if (p.password.length in 15 downTo 5) {
            errors.rejectValue("password", "[LENGTH]:outOfRange")
        }

        if (p.name.length in 20 downTo 3) {
            errors.rejectValue("name", "[LENGTH]:outOfRange")
        }
    }
}