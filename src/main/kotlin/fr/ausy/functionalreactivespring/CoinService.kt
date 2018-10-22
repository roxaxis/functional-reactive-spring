package fr.ausy.functionalreactivespring

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.SynchronousSink
import java.time.Duration
import java.time.Instant
import java.util.*

@Service
class CoinService {
    private val coinList = listOf("Bitcoin", "Ethereum", "Neo")
    fun getPrices(): Flux<CoinPriceEvent> {
        return Flux.generate<CoinPriceEvent> {
            sink: SynchronousSink<CoinPriceEvent> -> sink.next(CoinPriceEvent(coinList.random(), randomPrice(), Instant.now()))
        }.delayElements(Duration.ofSeconds(5)).log()

    }
    private fun randomPrice() = (400.00 + (600.00 - 400.00) * Random().nextDouble())

}

fun <E> List<E>.random(): E = get(Random().nextInt(size))