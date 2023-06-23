package net.jsrois.api.controllers

import net.jsrois.api.repositories.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.jvm.optionals.getOrNull

@RestController
@CrossOrigin
@RequestMapping("/api/products")
class ProductController(private val productRepository: ProductRepository) {
    @GetMapping
    fun allproducts() = productRepository.findAll().map{ProductDTO.from(it)}

    @GetMapping("/{id}")
    fun productById(@PathVariable id: String): ProductDTO? {
        val product = productRepository
            .findById(UUID.fromString(id))
            .getOrNull()

        if (product == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }


        return ProductDTO.from(product)
    }

    @DeleteMapping("/{id}")
    fun deleteProductById(@PathVariable id: String): ProductDTO? {
        val product = productRepository
            .findById(UUID.fromString(id))
            .getOrNull()

        if (product == null) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND)
        }
        productRepository.delete(product)

        return ProductDTO.from(product)
    }
}