package com.sejin.kopringbootpractice.cat

import com.ninjasquad.springmockk.MockkBean
import com.sejin.kopringbootpractice.common.ColorEnum
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.every
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*

@WebMvcTest
@AutoConfigureMockMvc
internal class CatControllerTest(
    @MockkBean private val catService: CatService,
    private val mvc: MockMvc,
) : BehaviorSpec({
    Given("CatController") {
        When("`GET /cat` is called") {
            every { catService.getCatList() } returns listOf(
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
            Then("The list of cats which is returned by CatService should be returned as a response") {
                mvc.perform(
                    MockMvcRequestBuilders.get("/api/cat")
                        .contentType(MediaType.APPLICATION_JSON)
                        .locale(Locale.KOREA)
                )
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].name").value("KimAeYong"))
                    .andExpect(jsonPath("$[0].kind").value("KOREAN_SHORT_HAIR"))
                    .andExpect(jsonPath("$[0].age").value(4))
                    .andExpect(jsonPath("$[0].furColor").value("CHEESE_YELLOW"))
                    .andExpect(jsonPath("$[1].name").value("TakeALook"))
                    .andExpect(jsonPath("$[1].kind").value("RUSSIAN_BLUE"))
                    .andExpect(jsonPath("$[1].age").value(7))
                    .andExpect(jsonPath("$[1].furColor").value("RUSSIAN_BLUE_GRAY"))
            }
        }
    }
})
