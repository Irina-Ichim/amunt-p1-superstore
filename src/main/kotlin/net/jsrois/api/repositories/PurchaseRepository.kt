package net.jsrois.api.repositories;

import net.jsrois.api.domain.Purchase
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PurchaseRepository : JpaRepository<Purchase, UUID> {
}