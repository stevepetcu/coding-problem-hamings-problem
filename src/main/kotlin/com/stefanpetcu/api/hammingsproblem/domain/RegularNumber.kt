package com.stefanpetcu.api.hammingsproblem.domain

import java.math.BigInteger

@JvmInline
value class RegularNumber(private val number: BigInteger) {
    operator fun minus(o2: RegularNumber): BigInteger {
        return number.subtract(o2.number)
    }
}
