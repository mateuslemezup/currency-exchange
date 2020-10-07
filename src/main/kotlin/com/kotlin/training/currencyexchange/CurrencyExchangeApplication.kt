package com.kotlin.training.currencyexchange

import com.kotlin.training.currencyexchange.integration.ExchangeClient
import com.kotlin.training.currencyexchange.integration.ExchangeManualClient
import com.kotlin.training.currencyexchange.repository.ExchangeLogRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class CurrencyExchangeApplication(
    val exchangeLogRepository: ExchangeLogRepository,
    val exchangeClient: ExchangeClient,
    val exchangeManualClient: ExchangeManualClient
) : ApplicationRunner {
    override fun run(args: ApplicationArguments?) {

//        val exchangeLogEntity = ExchangeLogEntity(
//            realAmount = 56.50.toBigDecimal(),
//            dolarAmount = 10.00.toBigDecimal()
//        )
//
//        exchangeLogRepository.save(exchangeLogEntity)

        exchangeLogRepository.findAll().forEach {
            println("Entidade do banco de dados: $it")
        }

//        val exchangeRate = exchangeClient.getExchangeRate()

        val exchangeRate = exchangeManualClient.getExchangeRate()

        println("Objeto Feign Auto: $exchangeRate")

    }

}

fun main(args: Array<String>) {
    runApplication<CurrencyExchangeApplication>(*args)
}
