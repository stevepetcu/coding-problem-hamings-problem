package com.stefanpetcu.api.hammingsproblem.support

import com.stefanpetcu.api.hammingsproblem.application.HammingNumbersCalculatorServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfiguration {
    @Bean
    fun hammingNumbersCalculator() = HammingNumbersCalculatorServiceImpl
}
