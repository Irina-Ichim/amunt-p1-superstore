package net.jsrois.api.controllers

import net.jsrois.api.domain.ShippingInfo
import net.jsrois.api.repositories.Customer
import java.util.*

data class CustomerDTO(val id: UUID, val name: String, val nif: String, val shippingInfo: ShippingInfoDTO) {
    companion object {
        fun from(customer: Customer) =
                with(customer) {
                    CustomerDTO(id, name, nif, ShippingInfoDTO.from(shippingInfo))
                }

    }
}

