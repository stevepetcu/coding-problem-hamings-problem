package com.stefanpetcu.api.hammingsproblem.presentation

import com.stefanpetcu.api.hammingsproblem.application.HammingNumbersCalculatorService
import com.stefanpetcu.api.hammingsproblem.domain.RegularNumber
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.math.BigInteger

@WebMvcTest(HammingController::class)
internal class HammingControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var hammingNumbersCalculator: HammingNumbersCalculatorService

    @Test
    fun regularNumbers_willReturnARegularNumbersResponseUntil10_givenNoUntilQueryParameter() {
        val mockServiceReturn: List<RegularNumber> = arrayListOf(1L, 2L, 3L, 4L, 5L, 6L, 8L, 9L, 10L, 12L)
            .map { n -> RegularNumber(BigInteger.valueOf(n)) }
        Mockito.`when`(hammingNumbersCalculator.getRegularNumbersUntil(10))
            .thenReturn(mockServiceReturn)

        mockMvc.perform(
            MockMvcRequestBuilders.get("/hamming/numbers")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().json(
                    "{" +
                        "    \"regularNumbers\": [" +
                        "        1," +
                        "        2," +
                        "        3," +
                        "        4," +
                        "        5," +
                        "        6," +
                        "        8," +
                        "        9," +
                        "        10," +
                        "        12" +
                        "    ]" +
                        "}"
                )
            )
    }

    @Test
    fun regularNumbers_willReturnARegularNumbersResponseUntil5_givenUntilQueryParameterEquals5() {
        val mockServiceReturn: List<RegularNumber> = arrayListOf(1L, 2L, 3L, 4L, 5L)
            .map { n -> RegularNumber(BigInteger.valueOf(n)) }
        Mockito.`when`(hammingNumbersCalculator.getRegularNumbersUntil(5))
            .thenReturn(mockServiceReturn)

        mockMvc.perform(
            MockMvcRequestBuilders.get("/hamming/numbers")
                .queryParam("until", "5")
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.content().json(
                    "{" +
                        "    \"regularNumbers\": [" +
                        "        1," +
                        "        2," +
                        "        3," +
                        "        4," +
                        "        5" +
                        "    ]" +
                        "}"
                )
            )
    }
}
