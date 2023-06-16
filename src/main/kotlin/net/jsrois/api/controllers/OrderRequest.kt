package net.jsrois.api.controllers

import java.util.*

data class OrderRequest(val id: UUID, val address: String, val postalCode: String, val city: String, val country: String)
