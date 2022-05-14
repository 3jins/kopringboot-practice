package com.sejin.kopringbootpractice.common

import io.kotest.core.spec.style.BehaviorSpec
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import java.util.*

@WebMvcTest
abstract class BaseControllerTest(private val mvc: MockMvc) : BehaviorSpec() {
    fun testByGet(url: String): ResultActions {
        return testByGet(url, HttpHeaders.EMPTY)
    }

    fun testByGet(url: String, headers: HttpHeaders): ResultActions {
        return mvc.perform(
            MockMvcRequestBuilders.get(url)
                .headers(headers)
                .contentType(MediaType.APPLICATION_JSON)
                .locale(Locale.KOREA)
        )
    }
}
