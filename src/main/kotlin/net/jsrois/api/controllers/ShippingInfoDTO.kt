package net.jsrois.api.controllers

import net.jsrois.api.domain.ShippingInfo
import java.util.*

data class ShippingInfoDTO(val id: UUID, val address: String, val city: String, val postalCode: String, val country: String) {
    companion object {
        fun from(shippingInfo: ShippingInfo) =
            with(shippingInfo) {
                ShippingInfoDTO(id, address, city, postalCode, country)
            }
    }
}
