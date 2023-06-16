package net.jsrois.api

import net.jsrois.api.controllers.CustomerDTO
import net.jsrois.api.controllers.ShippingInfoDTO
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
import org.springframework.http.HttpStatus.OK
import org.springframework.test.context.ActiveProfiles
import java.util.UUID

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
class CustomerApiTest {
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
    fun `returns customer information`() {
        val shippingInfo = shippingInfoRepository.save(
                ShippingInfo(id = UUID.randomUUID(),
                        address = "Carrer Muntaner 137 bajos",
                        city = "Barcelona",
                        postalCode = "08001",
                        country = "Spain")
        )

        val customer = customerRepository.save(
                Customer(id = UUID.randomUUID(),
                        name = "Pepito Perez",
                        nif = "42415125R",
                        shippingInfo = shippingInfo,
                        orders = emptySet())
        )

        val response = api.getForEntity("/api/customers/${customer.id}", CustomerDTO::class.java)

        assertThat(response.statusCode, equalTo(OK))

        assertThat(response.body, equalTo(CustomerDTO(
                id = customer.id,
                name = "Pepito Perez",
                nif = "42415125R",
                shippingInfo = ShippingInfoDTO(
                        id = shippingInfo.id,
                        address = "Carrer Muntaner 137 bajos",
                        city = "Barcelona",
                        postalCode = "08001",
                        country = "Spain"
                )
        )))


    }

    @Test
    fun `returns a 404 error when the user does not exist`() {
        val id = UUID.randomUUID()
        val response = api.getForEntity("/api/customers/${id}", Any::class.java)
        assertThat(response.statusCode, equalTo(HttpStatus.NOT_FOUND))
    }
}
