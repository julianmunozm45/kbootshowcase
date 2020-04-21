package com.julianmunozm45.kbootshowcase.service

import com.julianmunozm45.kbootshowcase.repository.ProductRepository
import org.springframework.stereotype.Component

@Component
class ProductService(private val repository: ProductRepository) : ProductRepository by repository