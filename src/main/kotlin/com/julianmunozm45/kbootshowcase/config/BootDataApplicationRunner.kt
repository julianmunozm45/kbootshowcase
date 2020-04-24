package com.julianmunozm45.kbootshowcase.config

import com.julianmunozm45.kbootshowcase.model.Product
import com.julianmunozm45.kbootshowcase.service.ProductService
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class BootDataApplicationRunner(private val productService: ProductService) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {
        val products = listOf(
                Product("Roast beef", 12.2),
                Product("Dagger", 10.9),
                Product("Curry rice", 15.6),
                Product("Fishhook", 1.3),
                Product("Onyx", 5440.77),
                Product("Hookshot", 209.9),
                Product("Ice rod", 409.88),
                Product("Gold emblem", 4599.34),
                Product("Sunglasses", 60.6),
                Product("Turquoise", 120.66),
                Product("Combat knife", 50.0),
                Product("Shiitake", 70.4),
                Product("Mirror cuirass", 3666.66),
                Product("Fire rod", 2500.0),
                Product("Crystal cloak", 4706.0),
                Product("Potion", 40.3),
                Product("Elixir", 1200.9),
                Product("Uncurse", 30.8)
        )

        productService.saveAll(products)
    }

}