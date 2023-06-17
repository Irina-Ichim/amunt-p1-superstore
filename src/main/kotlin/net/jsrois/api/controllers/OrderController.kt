package net.jsrois.api.controllers

import net.jsrois.api.domain.Order
import net.jsrois.api.domain.Purchase
import net.jsrois.api.repositories.CustomerRepository
import net.jsrois.api.repositories.OrderRepository
import net.jsrois.api.repositories.ProductRepository
import net.jsrois.api.repositories.PurchaseRepository
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.jvm.optionals.getOrNull

@RestController
class OrderController(
    private val customerRepository: CustomerRepository,
    private val orderRepository: OrderRepository,
    private val productRepository: ProductRepository,
    private val purchaseRepository: PurchaseRepository
) {

    @PostMapping("/api/customers/{customerId}/orders")
    fun addOrderForCustomerId(@PathVariable customerId: String, @RequestBody orderRequest: OrderRequest) =
        customerRepository.findById(UUID.fromString(customerId)).getOrNull()
            .takeIf { it !== null }
            ?.let { customer ->
                with(orderRequest) {
                    Order(
                        address = address,
                        city = city,
                        postalCode = postalCode,
                        country = country,
                        id = id,
                        purchases = emptyList(),
                        customer = customer
                    )
                }.let {
                    orderRepository.save(it).toOrderDto()
                }
            }
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    @PostMapping("/api/orders/{orderId}/products")
    fun addProduct(@PathVariable orderId: String, @RequestParam(required = true) productId: String): OrderDto {
        val product = productRepository.findById(UUID.fromString(productId)).getOrNull()
        val order = orderRepository.findById(UUID.fromString(orderId)).getOrNull()
        if (product == null || order == null) {
            throw ResponseStatusException(NOT_FOUND)
        }
        purchaseRepository.save(Purchase(product, order, UUID.randomUUID()))
        return order.toOrderDto()
    }

}

private fun Order.toOrderDto(): OrderDto {
    return OrderDto(id, address, city, country, postalCode, purchases.map { it.product.id })
}
