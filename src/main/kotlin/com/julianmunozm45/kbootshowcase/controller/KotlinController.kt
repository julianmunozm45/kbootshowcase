package com.julianmunozm45.kbootshowcase.controller

import com.julianmunozm45.kbootshowcase.model.Product
import com.julianmunozm45.kbootshowcase.service.ProductService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class KotlinController(private val productService: ProductService) {

    @GetMapping("/")
    fun homePage(model: Model): String {
        val products = productService.findAll()
        model.addAttribute("products", products)
        return "index"
    }

    @GetMapping("/greeting")
    fun greeting(
            @RequestParam(name = "name", defaultValue = "Kotlin", required = false) name: String,
            model: Model
    ): String {
        val product = Product()
        model.addAttribute("name", name)
        model.addAttribute("product", product)
        return "greeting"
    }

    @PostMapping("/addProduct")
    fun addProduct(@ModelAttribute("product") product: Product, result: BindingResult, model: Model): String {
        productService.save(product)
        model.addAttribute("product", product)
        return "redirect:/"
    }
}