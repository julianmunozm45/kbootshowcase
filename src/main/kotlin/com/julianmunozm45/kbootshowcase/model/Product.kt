package com.julianmunozm45.kbootshowcase.model

import javax.persistence.*

@Entity
data class Product(
        val name: String = "",
        val price: Double = 0.0,
        @ManyToOne
        @JoinColumn(name = "category_id")
        val category: Category = Category()
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
        private set
}