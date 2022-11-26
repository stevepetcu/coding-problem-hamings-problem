package com.stefanpetcu.api.hammingsproblem.presentation

import com.stefanpetcu.api.hammingsproblem.application.HammingNumbersCalculatorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController // See my cv-game app for an example using the @Controller annotation.
@RequestMapping("hamming")
class HammingController(private val hammingNumbersCalculator: HammingNumbersCalculatorService) {
    @GetMapping("/numbers")
    fun regularNumbers(
        @RequestParam(
            "until",
            required = false,
            defaultValue = "10"
        ) n: Int
    ): ResponseEntity<RegularNumbersResponse> {
        return ResponseEntity
            .ok()
            .body(RegularNumbersResponse(hammingNumbersCalculator.getRegularNumbersUntil(n)))
    }
}
