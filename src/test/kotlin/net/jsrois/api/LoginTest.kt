package net.jsrois.api

import net.jsrois.api.controllers.LoginRequest
import net.jsrois.api.controllers.LoginResponse
import net.jsrois.api.domain.ShippingInfo
import net.jsrois.api.repositories.Customer
import net.jsrois.api.repositories.CustomerRepository
import net.jsrois.api.repositories.ShippingInfoRepository
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import java.util.*

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
class LoginTest {

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var shippingInfoRepository: ShippingInfoRepository

    @Autowired
    private lateinit var api: TestRestTemplate

    @BeforeEach
    fun setUp() {
        customerRepository.deleteAll()
        shippingInfoRepository.deleteAll()
    }

    @Test
    fun `successful user login`() {
        val shippingInfo = shippingInfoRepository.save(
            ShippingInfo(
                id = UUID.randomUUID(),
                address = "Carrer Muntaner 137 bajos",
                city = "Barcelona",
                postalCode = "08001",
                country = "Spain"
            )
        )

        val customer = customerRepository.save(
            Customer(
                id = UUID.randomUUID(),
                name = "Pepito Perez",
                email = "pepito@example.com",
                password = "cambiame",
                nif = "42415125R",
                shippingInfo = shippingInfo,
                orders = emptySet()
            )
        )

        with(
            api.postForEntity(
                "/api/auth/login",
                LoginRequest(customer.email, customer.password),
                LoginResponse::class.java
            )
        ) {
            assertThat(statusCode, equalTo(HttpStatus.OK))
            assertThat(body, equalTo(LoginResponse(customer.id, customer.name)))
        }

    }

    @Test
    fun `user not found`() {
        with(
            api.postForEntity(
                "/api/auth/login",
                LoginRequest("some email", "some password"),
                Unit::class.java
            )
        ) {
            assertThat(statusCode, equalTo(HttpStatus.NOT_FOUND))
        }
    }

    @Test
    fun `wrong password`() {

        val shippingInfo = shippingInfoRepository.save(
            ShippingInfo(
                id = UUID.randomUUID(),
                address = "Carrer Muntaner 137 bajos",
                city = "Barcelona",
                postalCode = "08001",
                country = "Spain"
            )
        )

        val customer = customerRepository.save(
            Customer(
                id = UUID.randomUUID(),
                name = "Pepito Perez",
                email = "pepito@example.com",
                password = "cambiame",
                nif = "42415125R",
                shippingInfo = shippingInfo,
                orders = emptySet()
            )
        )
        with(
            api.postForEntity(
                "/api/auth/login",
                LoginRequest(customer.email, "wrongPassword"),
                Unit::class.java
            )
        ) {
            assertThat(statusCode, equalTo(HttpStatus.UNAUTHORIZED))
        }
    }
}