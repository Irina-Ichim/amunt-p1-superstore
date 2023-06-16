package net.jsrois.api.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "products")
class Product(
        var name: String,
        var price: Double,
        var imageUrl: String,
        @OneToMany(mappedBy = "product")
        var purchases: List<Purchase> = emptyList(),
        @Id
        var id: UUID
)
