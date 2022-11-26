package com.stefanpetcu.api.hammingsproblem.application

import com.stefanpetcu.api.hammingsproblem.domain.RegularNumber

sealed interface HammingNumbersCalculatorService {
    fun hamming(n: Int): RegularNumber
    fun getRegularNumbersUntil(n: Int): List<RegularNumber>
}
