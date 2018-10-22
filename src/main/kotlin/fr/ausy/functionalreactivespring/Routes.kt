package fr.ausy.functionalreactivespring

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.*
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.router

@Configuration
class Routes(private val coinHandler: CoinHandler) {
    @Bean
    fun apiRoutes() = router {
        accept(TEXT_HTML).nest {
            GET("/") { ok().render("index") }
        }
        "/api".nest {
            accept(APPLICATION_JSON).nest {
                GET("/coin", coinHandler::findAll)
            }
            accept(TEXT_EVENT_STREAM).nest{
                GET("/coin/prices", coinHandler::getAllPrices)
            }
        }
    }

}