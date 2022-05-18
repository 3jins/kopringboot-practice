package com.sejin.kopringbootpractice.cat

import com.sejin.kopringbootpractice.cat.enumeration.CatKindEnum
import com.sejin.kopringbootpractice.cat.model.CatEntity
import com.sejin.kopringbootpractice.common.ColorEnum
import com.sejin.kopringbootpractice.common.JpaConfig
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.date.shouldBeAfter
import io.kotest.matchers.date.shouldBeBefore
import io.kotest.matchers.shouldBe
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import java.time.LocalDateTime

@DataJpaTest
@Import(value = [JpaConfig::class])
internal class CatRepositoryTest(
    private val catRepository: CatRepository
) : BehaviorSpec({
    val catEntityList = listOf(
        CatEntity(
            id = 1,
            name = "KimAeYong",
            kind = CatKindEnum.KOREAN_SHORT_HAIR,
            age = 4,
            furColor = ColorEnum.CHEESE_YELLOW,
        ),
        CatEntity(
            id = 2,
            name = "TakeALook",
            kind = CatKindEnum.RUSSIAN_BLUE,
            age = 7,
            furColor = ColorEnum.RUSSIAN_BLUE_GRAY,
        ),
    )

    beforeSpec {
        catRepository.saveAll(catEntityList)
    }

    Given("CatRepository") {
        When("findAll is called") {
            catRepository.save(catEntityList[1])

            Then("A list of cats should be returned") {
                val result: List<CatEntity> = catRepository.findAll()
                println("cdt: " + result[0].createdDateTime)

                result shouldHaveSize 2
                result[0].name shouldBe "KimAeYong"
                result[0].kind shouldBe CatKindEnum.KOREAN_SHORT_HAIR
                result[0].age shouldBe 4
                result[0].furColor shouldBe ColorEnum.CHEESE_YELLOW
                result[0].createdDateTime shouldBeBefore LocalDateTime.now()
                result[0].updatedDateTime shouldBe result[0].createdDateTime
                result[1].name shouldBe "TakeALook"
                result[1].kind shouldBe CatKindEnum.RUSSIAN_BLUE
                result[1].age shouldBe 7
                result[1].furColor shouldBe ColorEnum.RUSSIAN_BLUE_GRAY
                result[1].createdDateTime shouldBeBefore LocalDateTime.now()
                result[1].updatedDateTime shouldBeAfter result[0].createdDateTime
            }
        }
    }
})
