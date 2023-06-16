package net.jsrois.api.controllers

import net.jsrois.api.repositories.CustomerRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/customers")
class CustomerController(private val customerRepository: CustomerRepository) {
    @GetMapping("/{id}")
    fun getCustomerById(@PathVariable id: String) =
            customerRepository.findById(UUID.fromString(id)).get()
                    .let { CustomerDTO.from(it) }
}