package net.jsrois.api.repositories

import net.jsrois.api.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProductRepository : JpaRepository<Product, UUID> {
    fun findByNameContainingIgnoreCase(word: String): List<Product>
    fun findByDiscountPriceNotNull(): List<Product>
}


