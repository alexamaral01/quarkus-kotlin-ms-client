package org.acme.ms.adapters.inbound.rest

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.MediaType.APPLICATION_JSON

import org.acme.ms.adapters.inbound.rest.dto.CustomerResponse
import org.eclipse.microprofile.openapi.annotations.Operation
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType
import org.eclipse.microprofile.openapi.annotations.media.*
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse


@Path("/customers")
class CustomerResource {

    @GET
    @Produces(APPLICATION_JSON)
    @Operation(
        summary = "Lista de clientes",
        description = "Retorna todos os clientes cadastrados")
    @APIResponse(
        responseCode = "200",
        description = "Lista de clientes",
        content = [Content(
            mediaType = APPLICATION_JSON,
            schema = Schema(
                implementation = CustomerResponse::class,
                type = SchemaType.ARRAY
            )
        )]
    )
    fun getCustomer(): List<CustomerResponse> {

        return listOf(
            CustomerResponse(1, "test 1", "teste1@acme.com"),
            CustomerResponse(2, "test 2", "teste2@acme.com"),
            CustomerResponse(3, "test 3", "teste3@acme.com")
        )
    }


}