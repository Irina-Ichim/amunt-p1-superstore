package net.jsrois.api.domain

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "shipping_info")
class ShippingInfo(val address: String,
                        val city: String,
                        val postalCode: String,
                        val country: String,
                        @Id
                        val id: UUID)
