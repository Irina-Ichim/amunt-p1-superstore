package net.jsrois.api.controllers

import net.jsrois.api.repositories.ProductRepository
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping("/api/products")
    fun allproducts(@RequestParam search: String?): List<ProductDTO> {
        if (!search.isNullOrBlank()) {
            val filteredProducts = productRepository.findByNameContainingIgnoreCase(search)
            return filteredProducts.map { ProductDTO.from(it) }
        }
        return productRepository.findAll().map { ProductDTO.from(it) }
    }
}