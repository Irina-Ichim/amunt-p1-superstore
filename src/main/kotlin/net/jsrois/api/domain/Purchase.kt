package net.jsrois.api.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name="purchases")
data class Purchase(
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JoinColumn(name = "product_id")
        var product: Product,
        @ManyToOne(cascade = [CascadeType.PERSIST])
        @JoinColumn(name = "order_id")
        var order: Order,
        @Id
        var id: UUID
)
