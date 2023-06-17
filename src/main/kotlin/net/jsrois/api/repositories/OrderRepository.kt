package net.jsrois.api.repositories;

import net.jsrois.api.domain.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrderRepository : JpaRepository<Order, UUID> {
    fun findAllByCustomerId(customer_id: UUID): List<Order>
}
