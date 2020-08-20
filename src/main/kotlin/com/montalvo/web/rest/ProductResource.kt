package com.montalvo.web.rest

import com.montalvo.domain.Product
import org.springframework.http.HttpStatus
import com.montalvo.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/api/Products")
class ProductResource(private val productService: ProductService) {

    @GetMapping
    fun getProducts(): List<Product> =
            productService.getProducts()

    @PostMapping
    fun addProduct(@RequestBody Product: Product): ResponseEntity<Product> =
            productService.addProduct(Product)

    @GetMapping("/slug/{slug}")
    fun findBySlug(@PathVariable slug:String): ResponseEntity<Product> =
            productService.getProductBySlug(slug)

    @GetMapping("/{id}")
    fun getProductById(@PathVariable(value="id") ProductId: Long): ResponseEntity<Product> =
            productService.getProductById(ProductId)

    @PutMapping("/{id}")
    fun updateProductById(
            @PathVariable(value = "id") ProductId: Long,
            @RequestBody newProduct: Product): ResponseEntity<Product> =
            productService.putProduct(ProductId, newProduct)

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable(value = "id") ProductId: Long): ResponseEntity<Void> =
            productService.deleteProduct(ProductId)
}
