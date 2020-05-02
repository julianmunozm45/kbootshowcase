package com.julianmunozm45.kbootshowcase.service

import com.julianmunozm45.kbootshowcase.model.Product
import com.julianmunozm45.kbootshowcase.repository.ProductRepository
import org.springframework.stereotype.Component

@Component
class ProductService(private val repository: ProductRepository) : ProductRepository by repository {

    fun checkout(categoryId: Long): Double {
        val products = findByCategory(categoryId)
        return products
                .map(Product::price)
                .sum()
    }

    fun findByCategory(categoryId: Long): Iterable<Product> {
        return when(categoryId) {
            1L -> repository.findAll()
            else -> repository.findByCategoryId(categoryId)
        }
    }
}