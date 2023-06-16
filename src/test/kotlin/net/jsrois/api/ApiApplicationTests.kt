package net.jsrois.api

import net.jsrois.api.domain.Product
import net.jsrois.api.repositories.ProductRepository
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.annotation.Profile
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.OK
import org.springframework.test.context.ActiveProfiles
import java.util.UUID

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ApiTests {
    @Autowired
    private lateinit var api: TestRestTemplate

    @Autowired
    private lateinit var productRepository: ProductRepository

    @Test
    fun `returns all products`() {
        val products = productRepository.saveAll(listOf(
                Product("IPhone 9", 799.99, "http://example.com/image.png", UUID.randomUUID()),
                Product("Toalla de playa", 13.99, "http://example.com/image.png", UUID.randomUUID())
        ))

        val response = api.getForEntity("/api/products", Array<Product>::class.java)

        assertThat(response.statusCode, equalTo(OK))
        assertThat(response.body?.asList(), equalTo(products))
    }
}
