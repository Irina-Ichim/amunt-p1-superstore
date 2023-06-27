package net.jsrois.api.domain

import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import net.jsrois.api.repositories.Customer
import net.jsrois.api.repositories.OrderRepository
import org.hibernate.annotations.CreationTimestamp
import java.util.*

@Entity
@Table(name = "orders")
class Order(
        @Id
        var id: UUID,
        var address: String,
        var city: String,
        var postalCode: String,
        var country: String,
        @ManyToOne
        @JoinColumn(name = "customer_id")
        var customer: Customer,
        @OneToMany(mappedBy = "order")
        var purchases: List<Purchase>,
        @CreationTimestamp
        var createdAt: Date? = null,
        var orderStatus: OrderStatus = OrderStatus.PENDING

)
