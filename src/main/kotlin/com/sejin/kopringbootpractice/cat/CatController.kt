package com.sejin.kopringbootpractice.cat

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class CatController(private val catService: CatService) {

    @GetMapping("/cat")
    fun getCats(): List<Cat> {
        return catService.getCatList()
    }
}
