package com.stefanpetcu.api.hammingsproblem.application

import com.stefanpetcu.api.hammingsproblem.domain.RegularNumber
import java.math.BigInteger
import java.util.PriorityQueue

object HammingNumbersCalculatorServiceImpl : HammingNumbersCalculatorService {
    private val THREE = BigInteger.valueOf(3) // TODO: These should be companion objects?
    private val FIVE = BigInteger.valueOf(5)

    private fun updateFrontier(x: BigInteger, pq: PriorityQueue<BigInteger>) {
        pq.add(x.shiftLeft(1))
        pq.add(x.multiply(THREE))
        pq.add(x.multiply(FIVE))
    }

    override fun hamming(n: Int): RegularNumber {
        val frontier = PriorityQueue<BigInteger>()
        updateFrontier(BigInteger.ONE, frontier)
        var lowest = BigInteger.ONE
        for (i in 1 until n) {
            lowest = frontier.poll() ?: lowest
            while (frontier.peek() == lowest)
                frontier.poll()
            updateFrontier(lowest, frontier)
        }

        return RegularNumber(lowest)
    }

    override fun getRegularNumbersUntil(n: Int): List<RegularNumber> {
        val numbers = arrayListOf<RegularNumber>()

        for (i in 1..n) {
            numbers.add(hamming(i))
        }

        return numbers
    }
}
