package fr.ausy.functionalreactivespring

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.ReactiveMongoRepository


interface CoinRepository: ReactiveMongoRepository<Coin, String>