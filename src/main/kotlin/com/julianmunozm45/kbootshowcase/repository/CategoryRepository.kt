package com.julianmunozm45.kbootshowcase.repository

import com.julianmunozm45.kbootshowcase.model.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : CrudRepository<Category, Long>