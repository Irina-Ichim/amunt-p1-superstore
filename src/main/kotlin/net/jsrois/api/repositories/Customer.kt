package net.jsrois.api.repositories

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import net.jsrois.api.domain.Order
import net.jsrois.api.domain.ShippingInfo
import java.util.UUID

@Entity
@Table(name = "customers")
data class Customer(
        @Id
        val id: UUID,
        val name: String,
        val nif: String,
        @OneToOne(cascade = [CascadeType.PERSIST])
        val shippingInfo: ShippingInfo,
        @OneToMany
        val orders: Set<Order>)
