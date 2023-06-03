package net.jsrois.api.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name="products")
data class Product(
    var name: String,
    var price: Double,
    var imageUrl: String,
    @Id
    var id: UUID
)
