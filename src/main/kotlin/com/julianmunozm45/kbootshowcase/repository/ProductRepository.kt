package com.julianmunozm45.kbootshowcase.repository

import com.julianmunozm45.kbootshowcase.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Long> {
    fun findByName(name: String): Product
}