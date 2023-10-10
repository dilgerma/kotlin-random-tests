package de.nebulit.randomtestdemo

import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters
import java.util.*

inline fun <reified T> randomData(block: T.()->Unit = {}): T {
    val parameters = EasyRandomParameters()
        .collectionSizeRange(1, 4)
        .randomize(UUID::class.java) { UUID.randomUUID() }

    val generator = EasyRandom(parameters)
    return generator.nextObject(T::class.java).also(block)
}
