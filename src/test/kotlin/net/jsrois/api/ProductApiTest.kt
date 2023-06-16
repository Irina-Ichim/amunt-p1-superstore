package net.jsrois.api

import net.jsrois.api.controllers.ProductDTO
import net.jsrois.api.domain.Product
import net.jsrois.api.repositories.ProductRepository
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus.OK
import org.springframework.test.context.ActiveProfiles
import java.util.UUID

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ProductApiTest {
    @Autowired
    private lateinit var api: TestRestTemplate

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Test
    fun `returns all products`() {
        val products = productRepository.saveAll(listOf(
                Product(name = "IPhone 9", price = 799.99, imageUrl = "http://example.com/image.png", id = UUID.randomUUID()),
                Product(name = "Toalla de playa", price = 13.99, imageUrl = "http://example.com/image.png", id = UUID.randomUUID())
        ))

        val response = api.getForEntity("/api/products", Array<ProductDTO>::class.java)

        assertThat(response.statusCode, equalTo(OK))
        assertThat(response.body?.asList(), equalTo(products.map{ProductDTO.from(it)}))
    }
}
