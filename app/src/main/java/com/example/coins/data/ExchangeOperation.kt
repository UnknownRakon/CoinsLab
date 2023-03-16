package com.example.coins.data

import java.time.LocalDateTime

data class ExchangeOperation(
    val firstCurrency: Currency,
    val firstCurrencyAmount: Int,
    val secondCurrency: Currency,
    val secondCurrencyAmount: Int,
    val date: LocalDateTime
)
