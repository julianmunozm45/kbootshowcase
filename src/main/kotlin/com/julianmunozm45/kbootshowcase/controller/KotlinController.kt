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
        model.addAttribute("total", 0.0)
        return "index"
    }

    @GetMapping("/check-in")
    fun checkIn(
            @RequestParam(name = "greet", defaultValue = "Got some rare things on sale, stranger!", required = false) name: String,
            model: Model
    ): String {
        val product = Product()
        model.addAttribute("greet", name)
        model.addAttribute("product", product)
        return "check-in"
    }

    @PostMapping("/add-product")
    fun addProduct(@ModelAttribute("product") product: Product, result: BindingResult, model: Model): String {
        productService.save(product)
        model.addAttribute("product", product)
        return "redirect:/"
    }

    @GetMapping("/check-out")
    fun checkOut(model: Model): String {
        val total = productService.checkout()
        model.addAttribute("total", total)
        return "index :: total"
    }
}