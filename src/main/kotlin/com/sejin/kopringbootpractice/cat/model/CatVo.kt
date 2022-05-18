package com.sejin.kopringbootpractice.cat.model

import com.sejin.kopringbootpractice.cat.enumeration.CatKindEnum
import com.sejin.kopringbootpractice.common.ColorEnum

data class CatVo(
    val name: String,
    val kind: CatKindEnum,
    val furColor: ColorEnum,
    val age: Int,
)
