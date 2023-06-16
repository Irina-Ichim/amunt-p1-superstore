package net.jsrois.api.repositories

import net.jsrois.api.domain.ShippingInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomerRepository: JpaRepository<Customer, UUID>