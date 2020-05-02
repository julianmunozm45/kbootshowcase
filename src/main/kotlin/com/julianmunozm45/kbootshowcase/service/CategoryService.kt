package com.julianmunozm45.kbootshowcase.service

import com.julianmunozm45.kbootshowcase.repository.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val repository: CategoryRepository) : CategoryRepository by repository