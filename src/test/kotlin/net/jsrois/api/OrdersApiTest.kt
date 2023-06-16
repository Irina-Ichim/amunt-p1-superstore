package net.jsrois.api

import jakarta.transaction.Transactional
import net.jsrois.api.controllers.OrderDto
import net.jsrois.api.domain.Order
import net.jsrois.api.domain.Product
import net.jsrois.api.domain.Purchase
import net.jsrois.api.domain.ShippingInfo
import net.jsrois.api.repositories.*
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
import java.util.*

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
class OrdersApiTest {
    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var shippingInfoRepository: ShippingInfoRepository

    @Autowired
    private lateinit var api: TestRestTemplate

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Autowired
    private lateinit var orderRepository: OrderRepository
    @Autowired
    private lateinit var purchaseRepository: PurchaseRepository

    @BeforeEach
    fun setUp() {
        customerRepository.deleteAll()
        shippingInfoRepository.deleteAll()
    }

    @Test
    @Transactional
    fun `returns customer orders`() {
        val shippingInfo = createShippingInfo()

        val products = productRepository.saveAll(listOf(
                Product(name = "IPhone 9", price = 799.99, imageUrl = "http://example.com/image.png", id = UUID.randomUUID()),
                Product(name = "Toalla de playa", price = 13.99, imageUrl = "http://example.com/image.png", id = UUID.randomUUID())
        ))

        val orders = orderRepository.saveAll(setOf(
                Order(id = UUID.randomUUID(),
                    address = shippingInfo.address,
                        city = shippingInfo.city,
                        country = shippingInfo.country,
                        postalCode = shippingInfo.postalCode)
        ))

        purchaseRepository.saveAll(listOf(
                Purchase(products[0], orders[0], UUID.randomUUID()),
                Purchase(products[0], orders[0], UUID.randomUUID()),
                Purchase(products[1], orders[0], UUID.randomUUID())
        ))

        val customer = createCustomer(shippingInfo = shippingInfo, orders = orders)

        val response = api.getForEntity("/api/customers/${customer.id}/orders", OrderDto::class.java)

        assertThat(response.statusCode, equalTo(OK))

        assertThat(response.body, equalTo(OrderDto(
                id = orders[0].id,
                address = shippingInfo.address,
                city = shippingInfo.city,
                country = shippingInfo.country,
                postalCode = shippingInfo.postalCode
        )))


    }

    private fun createCustomer(shippingInfo: ShippingInfo, orders: List<Order>) = customerRepository.save(
            Customer(id = UUID.randomUUID(),
                    name = "Pepito Perez",
                    nif = "42415125R",
                    shippingInfo = shippingInfo,
                    orders = orders.toSet())
    )

    private fun createShippingInfo() = shippingInfoRepository.save(
            ShippingInfo(id = UUID.randomUUID(),
                    address = "Carrer Muntaner 137 bajos",
                    city = "Barcelona",
                    postalCode = "08001",
                    country = "Spain")
    )

    @Test
    fun `returns a 404 error when the user does not exist`() {
        val id = UUID.randomUUID()
        val response = api.getForEntity("/api/customers/${id}", Any::class.java)
        assertThat(response.statusCode, equalTo(HttpStatus.NOT_FOUND))
    }
}
