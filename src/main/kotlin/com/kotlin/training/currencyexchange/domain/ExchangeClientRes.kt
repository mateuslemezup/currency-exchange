package com.kotlin.training.currencyexchange.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

@JsonIgnoreProperties(ignoreUnknown = true)
data class ExchangeClientRes(
    @JsonProperty("rates")
    val rate: Rate
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class Rate(
    @JsonProperty("USD")
    val usd: BigDecimal = BigDecimal.ZERO,
    @JsonProperty("BRL")
    val brl: BigDecimal = BigDecimal.ZERO
)