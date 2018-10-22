package fr.ausy.functionalreactivespring

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToServerSentEvents

@Component
class CoinHandler(private val coinRepository: CoinRepository, private val coinService: CoinService) {
    fun findAll(req: ServerRequest) = ok().body(coinRepository.findAll())
    fun findById(req: ServerRequest) = ok().body(coinRepository.findById(req.pathVariable("id")))

    fun getAllPrices(req: ServerRequest) = ok().bodyToServerSentEvents(coinService.getPrices())
}