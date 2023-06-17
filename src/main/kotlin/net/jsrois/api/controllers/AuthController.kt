package net.jsrois.api.controllers

import net.jsrois.api.repositories.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/api/auth")
class AuthController(private val customerRepository: CustomerRepository) {

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): LoginResponse =
            customerRepository.findByEmailEquals(loginRequest.username).getOrNull()
                    ?.let { customer ->
                        customer.takeIf { it.password == loginRequest.password }
                                ?.let { LoginResponse(customer.id) }
                                ?: throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
                    }
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

}