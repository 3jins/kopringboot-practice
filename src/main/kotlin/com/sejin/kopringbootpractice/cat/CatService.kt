package com.sejin.kopringbootpractice.cat

import com.sejin.kopringbootpractice.common.ColorEnum
import org.springframework.stereotype.Service

@Service
class CatService {
    fun getCatList(): List<Cat> {
        return listOf(
            Cat(
                name = "KimAeYong",
                kind = CatKindEnum.KOREAN_SHORT_HAIR,
                furColor = ColorEnum.CHEESE_YELLOW,
                age = 4,
            ),
            Cat(
                name = "TakeALook",
                kind = CatKindEnum.RUSSIAN_BLUE,
                furColor = ColorEnum.RUSSIAN_BLUE_GRAY,
                age = 7,
            ),
        )
    }
}
