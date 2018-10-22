package fr.ausy.functionalreactivespring

import org.springframework.data.annotation.Id
import java.time.Instant

data class Coin(
        @Id
        val id: String? = null,
        val name: String
)

data class CoinPriceEvent(
        val name: String,
        val price: Double,
        val date: Instant
)