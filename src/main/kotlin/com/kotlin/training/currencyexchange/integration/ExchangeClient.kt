package com.kotlin.training.currencyexchange.integration

import com.kotlin.training.currencyexchange.domain.ExchangeClientRes
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping

@FeignClient(name = "ExchangeClient", url = "\${exchangeclient.host}")
interface ExchangeClient {

    @GetMapping("/v6/latest")
    fun getExchangeRate(): ExchangeClientRes

}