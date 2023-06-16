package net.jsrois.api.domain

import jakarta.persistence.*
import net.jsrois.api.repositories.Customer
import org.hibernate.annotations.CreationTimestamp
import java.util.*

@Entity
@Table(name = "orders")
data class Order(
        var address: String,
        var city: String,
        var postalCode: String,
        var country: String,
        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name="customer_id")
        var customer: Customer,
        @CreationTimestamp
        var createdAt: Date? = null,
        @Id
        var id: UUID
)
