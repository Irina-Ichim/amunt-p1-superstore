package net.jsrois.api.controllers

import net.jsrois.api.domain.Product
import net.jsrois.api.repositories.ProductRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(private val productRepository: ProductRepository) {
    @GetMapping
    @CrossOrigin
    fun allproducts() = productRepository.findAll().map{ProductDTO.from(it)}
}