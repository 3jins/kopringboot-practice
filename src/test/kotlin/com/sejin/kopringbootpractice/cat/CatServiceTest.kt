package com.sejin.kopringbootpractice.cat

import com.sejin.kopringbootpractice.cat.enumeration.CatKindEnum
import com.sejin.kopringbootpractice.cat.model.CatEntity
import com.sejin.kopringbootpractice.cat.model.CatVo
import com.sejin.kopringbootpractice.common.ColorEnum
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

internal class CatServiceTest : BehaviorSpec({
    val catRepository = mockk<CatRepository>()
    val catService = CatService(catRepository)

    Given("CatService") {
        When("getCatList is called") {
            every { catRepository.findAll() } returns listOf(
                CatEntity(
                    id = 1,
                    name = "KimAeYong",
                    kind = CatKindEnum.KOREAN_SHORT_HAIR,
                    furColor = ColorEnum.CHEESE_YELLOW,
                    age = 4,
                ),
                CatEntity(
                    id = 2,
                    name = "TakeALook",
                    kind = CatKindEnum.RUSSIAN_BLUE,
                    furColor = ColorEnum.RUSSIAN_BLUE_GRAY,
                    age = 7,
                ),
            )
            Then("A list of cats should be returned") {
                val catVoList: List<CatVo> = catService.getCatList()
                catVoList shouldHaveSize 2
                catVoList[0].name shouldBe "KimAeYong"
                catVoList[0].kind shouldBe CatKindEnum.KOREAN_SHORT_HAIR
                catVoList[0].age shouldBe 4
                catVoList[0].furColor shouldBe ColorEnum.CHEESE_YELLOW
                catVoList[1].name shouldBe "TakeALook"
                catVoList[1].kind shouldBe CatKindEnum.RUSSIAN_BLUE
                catVoList[1].age shouldBe 7
                catVoList[1].furColor shouldBe ColorEnum.RUSSIAN_BLUE_GRAY
            }
        }
    }
})
