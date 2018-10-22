package fr.ausy.functionalreactivespring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FunctionalReactiveSpringApplication

fun main(args: Array<String>) {
    runApplication<FunctionalReactiveSpringApplication>(*args)
}
