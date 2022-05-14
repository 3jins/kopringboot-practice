package com.sejin.kopringbootpractice.cat

import com.sejin.kopringbootpractice.common.ColorEnum

data class Cat(
    val name: String,
    val kind: CatKindEnum,
    val furColor: ColorEnum,
    val age: Int,
)
