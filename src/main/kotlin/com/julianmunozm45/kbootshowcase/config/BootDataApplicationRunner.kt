package com.julianmunozm45.kbootshowcase.config

import com.julianmunozm45.kbootshowcase.model.Category
import com.julianmunozm45.kbootshowcase.model.Product
import com.julianmunozm45.kbootshowcase.service.CategoryService
import com.julianmunozm45.kbootshowcase.service.ProductService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class BootDataApplicationRunner(
        private val productService: ProductService,
        private val categoryService: CategoryService
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {

        val all = Category(id = -1L, name = "All")
        val cusine = Category(name = "Cusine")
        val weapons = Category(name = "Weapons")
        val armor = Category(name = "Armor")
        val accessories = Category(name = "Accessories")
        val items = Category(name = "Items")
        val categories = listOf(all, cusine, weapons, armor, accessories, items)
        categoryService.saveAll(categories)

        val products = listOf(
                Product("Roast beef", 12.2, cusine),
                Product("Dagger", 10.9, weapons),
                Product("Curry rice", 15.6, cusine),
                Product("Fishhook", 1.3, items),
                Product("Onyx", 5440.77, accessories),
                Product("Hookshot", 209.9, weapons),
                Product("Ice rod", 409.88, weapons),
                Product("Gold emblem", 4599.34, accessories),
                Product("Sunglasses", 60.6, accessories),
                Product("Turquoise", 120.66, accessories),
                Product("Combat knife", 50.0, weapons),
                Product("Shiitake", 70.4, cusine),
                Product("Mirror cuirass", 3666.66, armor),
                Product("Fire rod", 2500.0, weapons),
                Product("Crystal cloak", 4706.0, armor),
                Product("Potion", 40.3, items),
                Product("Elixir", 1200.9, items),
                Product("Uncurse", 30.8, items)
        )

        productService.saveAll(products)
    }

}