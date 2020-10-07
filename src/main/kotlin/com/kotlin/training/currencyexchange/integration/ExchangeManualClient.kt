package com.kotlin.training.currencyexchange.integration

import com.kotlin.training.currencyexchange.domain.ExchangeClientRes
import org.springframework.web.bind.annotation.GetMapping

interface ExchangeManualClient {

    @GetMapping("/v6/latest")
    fun getExchangeRate(): ExchangeClientRes

}