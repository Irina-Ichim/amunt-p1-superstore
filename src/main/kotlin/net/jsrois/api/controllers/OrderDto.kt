package net.jsrois.api.controllers

import net.jsrois.api.domain.Order
import java.util.UUID


data class OrderDto(val id: UUID,
                    val address: String,
                    val city: String,
                    val country: String,
                    val postalCode: String,
                    val products: List<ProductDTO>) {
    companion object
}