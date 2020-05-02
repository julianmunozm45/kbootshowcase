package com.julianmunozm45.kbootshowcase.service

import com.julianmunozm45.kbootshowcase.model.Category
import com.julianmunozm45.kbootshowcase.repository.CategoryRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CategoryService(private val repository: CategoryRepository) : CategoryRepository by repository {
    fun findAllSorted(): MutableIterable<Category> {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"))
    }
}