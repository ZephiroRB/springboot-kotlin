package com.montalvo.service

import com.montalvo.domain.Product
import com.montalvo.repository.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getProductBySlug(slug: String): ResponseEntity<Product> {
        val optionalPerson: Optional<Product> = productRepository.findBySlug(slug)
        return optionalPerson.map { product ->
            ResponseEntity.ok(product)
        }.orElse(ResponseEntity.notFound().build())
    }


    fun getProducts(): List<Product> =
            productRepository.findAll()

    fun addProduct(product: Product): ResponseEntity<Product> =
            ResponseEntity.ok(productRepository.save(product))

    fun getProductById(productId: Long): ResponseEntity<Product> =
            productRepository.findById(productId).map { product ->
                ResponseEntity.ok(product)
            }.orElse(ResponseEntity.notFound().build())


    fun putProduct(productId: Long, newProduct: Product): ResponseEntity<Product> =
            productRepository.findById(productId).map { currentProduct ->
                val updatedProduct: Product =
                        currentProduct
                                .copy(
                                        title = newProduct.title,
                                        description = newProduct.description
                                )
                ResponseEntity.ok().body(productRepository.save(updatedProduct))
            }.orElse(ResponseEntity.notFound().build())

    fun deleteProduct(productId: Long): ResponseEntity<Void> =
            productRepository.findById(productId).map { product ->
                productRepository.delete(product)
                ResponseEntity<Void>(HttpStatus.ACCEPTED)
            }.orElse(ResponseEntity.notFound().build())
}
