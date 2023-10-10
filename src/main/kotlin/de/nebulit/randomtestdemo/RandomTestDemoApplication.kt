package de.nebulit.randomtestdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class RandomTestDemoApplication

fun main(args: Array<String>) {
	runApplication<RandomTestDemoApplication>(*args)
}
