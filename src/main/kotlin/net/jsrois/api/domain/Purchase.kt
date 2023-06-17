package net.jsrois.api.domain

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="purchases")
class Purchase(
        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name = "product_id")
        var product: Product,
        @ManyToOne(cascade = [CascadeType.MERGE])
        @JoinColumn(name = "order_id")
        var order: Order,
        @Id
        var id: UUID
)
