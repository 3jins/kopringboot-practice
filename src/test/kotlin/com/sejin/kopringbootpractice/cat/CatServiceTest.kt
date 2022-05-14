package com.sejin.kopringbootpractice.cat

import com.sejin.kopringbootpractice.common.ColorEnum
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

internal class CatServiceTest : BehaviorSpec({
    val catService = CatService()

    Given("CatService") {
        When("getCatList is called") {
            Then("A list of cats should be returned") {
                val catList: List<Cat> = catService.getCatList()
                catList shouldHaveSize 2
                catList[0].name shouldBe "KimAeYong"
                catList[0].kind shouldBe CatKindEnum.KOREAN_SHORT_HAIR
                catList[0].age shouldBe 4
                catList[0].furColor shouldBe ColorEnum.CHEESE_YELLOW
                catList[1].name shouldBe "TakeALook"
                catList[1].kind shouldBe CatKindEnum.RUSSIAN_BLUE
                catList[1].age shouldBe 7
                catList[1].furColor shouldBe ColorEnum.RUSSIAN_BLUE_GRAY
            }
        }
    }
})
