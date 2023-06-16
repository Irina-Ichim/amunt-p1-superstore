package net.jsrois.api.domain

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import java.util.*

@Entity
@Table(name = "orders")
data class Order(
        var address: String,
        var city: String,
        var postalCode: String,
        var country: String,
        @OneToMany(mappedBy = "order")
        var purchases: Set<Purchase> = emptySet(),
        @CreationTimestamp
        var createdAt: Date? = null,
        @Id
        var id: UUID
)
