package net.jsrois.api.controllers

import net.jsrois.api.domain.OrderStatus

data class OrderStatusChangeRequest(
    val status: OrderStatus
)
