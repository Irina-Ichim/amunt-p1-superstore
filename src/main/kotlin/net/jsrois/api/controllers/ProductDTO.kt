package net.jsrois.api.controllers

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import net.jsrois.api.domain.Product
import java.util.UUID

data class ProductDTO(
        var name: String,
        var price: Double,
        var discountPrice: Double? = null,
        var imageUrl: String,
        var description: String,
        var id: UUID
) {
    companion object {
        fun from(product: Product) = with(product) {
            ProductDTO(name, price, discountPrice, imageUrl, descriptionText, id)
        }
    }
}
