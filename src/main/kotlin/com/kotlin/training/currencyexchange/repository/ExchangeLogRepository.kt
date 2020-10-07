package com.kotlin.training.currencyexchange.repository

import com.kotlin.training.currencyexchange.domain.ExchangeLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExchangeLogRepository : JpaRepository<ExchangeLogEntity, UUID> {

}