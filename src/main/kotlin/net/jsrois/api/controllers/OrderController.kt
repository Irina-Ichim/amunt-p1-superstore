package net.jsrois.api.controllers

import net.jsrois.api.domain.Order
import net.jsrois.api.repositories.CustomerRepository
import net.jsrois.api.repositories.OrderRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.jvm.optionals.getOrNull

@RestController
class OrderController(private val customerRepository: CustomerRepository, private val orderRepository: OrderRepository) {

    @PostMapping("/api/customers/{customerId}/orders")
    fun addOrderForCustomerId(@PathVariable customerId: String, @RequestBody orderRequest: OrderRequest) {
        customerRepository.findById(UUID.fromString(customerId))
                .getOrNull()
                ?.let { customer ->
                    with(orderRequest) {
                        Order(address = address,
                                city = city,
                                postalCode = postalCode,
                                country = country,
                                id = id,
                                customer = customer)
                    }.let {
                        orderRepository.save(it)
                    }
                }
    }

}
