package com.kotlin.training.currencyexchange.integration.config

import com.kotlin.training.currencyexchange.integration.ExchangeManualClient
import com.kotlin.training.currencyexchange.integration.config.base.DefaultErrorDecoder
import com.kotlin.training.currencyexchange.integration.config.base.FeignBaseConfig
import feign.RequestInterceptor
import feign.codec.ErrorDecoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*

const val MODULE_NAME = "TRAINING-KOTLIN"

@Configuration
class ExchangeRateClientConfig(@Value("\${exchangeclient.host}") private val partnerHost: String) : FeignBaseConfig() {

    @Bean
    fun exchangeManualClient(): ExchangeManualClient {
        return createBuilder()
            .target(ExchangeManualClient::class.java, partnerHost)
    }

    override fun interceptor(): RequestInterceptor {
        return RequestInterceptor {
            it.header("Authentication", "${UUID.randomUUID()}")
            it.header("x-itau-flowID", "123")
        }
    }

    override fun errorDecoder(): ErrorDecoder {
        return DefaultErrorDecoder(MODULE_NAME)
    }
}