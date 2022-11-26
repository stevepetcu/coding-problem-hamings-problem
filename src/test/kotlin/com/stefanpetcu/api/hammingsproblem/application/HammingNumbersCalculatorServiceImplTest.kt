package com.stefanpetcu.api.hammingsproblem.application

import com.stefanpetcu.api.hammingsproblem.domain.RegularNumber
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.math.BigInteger

internal class HammingNumbersCalculatorServiceImplTest {
    private val testSubject: HammingNumbersCalculatorServiceImpl = HammingNumbersCalculatorServiceImpl

    @Suppress("unused")
    companion object {
        @JvmStatic
        fun regularNumbersProvider() = listOf(
            Arguments.of(0, arrayListOf<RegularNumber>()),
            Arguments.of(1, arrayListOf(1L).map { n -> RegularNumber(BigInteger.valueOf(n)) }),
            Arguments.of(
                5,
                arrayListOf(1L, 2L, 3L, 4L, 5L).map { n -> RegularNumber(BigInteger.valueOf(n)) }
            ),
            Arguments.of(
                10,
                arrayListOf(1L, 2L, 3L, 4L, 5L, 6L, 8L, 9L, 10L, 12L)
                    .map { n -> RegularNumber(BigInteger.valueOf(n)) }
            ),
            Arguments.of(
                25,
                arrayListOf(
                    1L, 2L, 3L, 4L, 5L, 6L, 8L, 9L, 10L, 12L, 15L, 16L, 18L,
                    20L, 24L, 25L, 27L, 30L, 32L, 36L, 40L, 45L, 48L, 50L, 54L
                )
                    .map { n -> RegularNumber(BigInteger.valueOf(n)) }
            ),
        )
    }

    @ParameterizedTest
    @MethodSource("regularNumbersProvider")
    fun getRegularNumbersUntil2(input: Int, expected: ArrayList<RegularNumber>) {
        assertEquals(expected, testSubject.getRegularNumbersUntil(input))
    }
}
