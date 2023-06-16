package net.jsrois.api.controllers

import net.jsrois.api.repositories.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.jvm.optionals.getOrNull

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerRepository: CustomerRepository) {
    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: String) =
            customerRepository
                    .findById(UUID.fromString(id))
                    .getOrNull()
                    ?.let { CustomerDTO.from(it) }
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Customer $id not found")

}