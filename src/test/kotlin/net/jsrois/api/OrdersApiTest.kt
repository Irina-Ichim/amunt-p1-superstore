package net.jsrois.api

import net.jsrois.api.controllers.OrderDto
import net.jsrois.api.controllers.OrderRequest
import net.jsrois.api.domain.Order
import net.jsrois.api.domain.Product
import net.jsrois.api.domain.ShippingInfo
import net.jsrois.api.repositories.*
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.contains
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
class OrdersApiTest {

    @Autowired
    private lateinit var api: TestRestTemplate

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var shippingInfoRepository: ShippingInfoRepository

    @Autowired
    private lateinit var productRepository: ProductRepository


    @BeforeEach
    fun setUp() {

    }


    @Test
    fun `allows to create an order and add products to it`() {

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

        val newOrder = OrderRequest(
                id = UUID.randomUUID(),
                address = "Carrer de Muntaner 145, 1-2",
                postalCode = "08011",
                city = "Barcelona",
                country = "Spain"
        )

        val product1 = productRepository.save(Product(name = "IPhone 9", price = 799.99, imageUrl = "http://example.com/image.png", id = UUID.randomUUID()))
        val product2 = productRepository.save(Product(name = "Toalla de playa", price = 13.99, imageUrl = "http://example.com/image.png", id = UUID.randomUUID()))

        api.postForEntity("/api/customers/${customer.id}/orders",
                newOrder, Order::class.java).let {
            assertThat(it.statusCode, equalTo(HttpStatus.OK))
        }

        api.postForEntity("/api/orders/${newOrder.id}/products?productId=${product1.id}",
                Unit, OrderDto::class.java).let {
            assertThat(it.statusCode, equalTo(HttpStatus.OK))
            assertThat(it.body?.products, equalTo(listOf(product1.id)))
        }


    }

}
