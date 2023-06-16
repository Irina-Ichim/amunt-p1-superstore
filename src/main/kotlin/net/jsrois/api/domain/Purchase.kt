package net.jsrois.api.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

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
