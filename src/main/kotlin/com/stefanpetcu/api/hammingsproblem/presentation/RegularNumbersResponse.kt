package com.stefanpetcu.api.hammingsproblem.presentation

import com.stefanpetcu.api.hammingsproblem.domain.RegularNumber

data class RegularNumbersResponse(
    val regularNumbers: List<RegularNumber>
)
