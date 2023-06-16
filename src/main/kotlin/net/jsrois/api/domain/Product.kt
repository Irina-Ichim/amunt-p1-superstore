package net.jsrois.api.domain

import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "products")
data class Product(
        var name: String,
        var price: Double,
        var imageUrl: String,
        @OneToMany(mappedBy = "product", cascade = [CascadeType.REFRESH])
        var purchases: Set<Purchase> = emptySet(),
        @Id
        var id: UUID
)
