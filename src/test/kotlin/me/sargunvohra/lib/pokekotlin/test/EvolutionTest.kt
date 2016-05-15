package me.sargunvohra.lib.pokekotlin.test

import me.sargunvohra.lib.pokekotlin.api.PokeApi
import me.sargunvohra.lib.pokekotlin.api.promise
import org.testng.annotations.Test
import kotlin.test.*

class EvolutionTest {

    @Test
    fun getEvolutionChain() {
        PokeApi.getEvolutionChain(7).promise.get().apply {
            assertEquals(7, id)
            assertEquals(null, babyTriggerItem)
            chain.apply {
                assertEquals(false, isBaby)
                species.apply {
                    assertEquals("rattata", name)
                    assertEquals(PokeApi.rootUrl + "pokemon-species/19/", url)
                }
                assertEquals(null, evolutionDetails)
                assert(evolvesTo.isNotEmpty())
            }
        }
    }

    // TODO test different types of evolution
    // TODO test other evolution endpoints
}