package net.jsrois.api.domain

import jakarta.persistence.*
import org.hibernate.Length
import org.hibernate.annotations.Type
import java.util.*

@Entity
@Table(name = "products")
class Product(
        var name: String,
        var price: Double,
        var imageUrl: String,
        var descriptionText: String,
        @OneToMany(mappedBy = "product")
        var purchases: List<Purchase> = emptyList(),
        @Id
        var id: UUID
)
