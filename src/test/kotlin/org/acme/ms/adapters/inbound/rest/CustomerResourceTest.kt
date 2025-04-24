package org.acme.ms.adapters.inbound.rest

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.hamcrest.Matchers.*

@QuarkusTest
class CustomerResourceTest {

    @Test
    fun getCustomer() {
        given()
            .`when`().get("/customers")
            .then()
            .statusCode(200)
            .body("$.size()", `is`(3))
            .body("[0].name", equalTo("test 1"))
            .body("[2].email", equalTo("teste3@acme.com"))
    }
}