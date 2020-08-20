package com.montalvo.domain

import com.montalvo.config.toSlug
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val title: String,
        val slug: String = title.toSlug(),
        @Column(columnDefinition = "TEXT")
        val description: String,
        val createAt: LocalDateTime? = LocalDateTime.now(),
        val updatedAt: LocalDateTime? = LocalDateTime.now()
)