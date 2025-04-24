package org.acme.ms.adapters.inbound.rest.dto

data class CustomerResponse(
    val id: Long,
    val name: String,
    val email: String
)