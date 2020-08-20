package com.montalvo.repository

import com.montalvo.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import java.util.*
import javax.transaction.Transactional

@Repository
//@Transactional(Transactional.TxType.MANDATORY)
interface ProductRepository: JpaRepository<Product, Long> {
    fun findBySlug(slug: String): Optional<Product>
}