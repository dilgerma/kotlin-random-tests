package de.nebulit.randomtestdemo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.time.LocalDate
import java.time.LocalDateTime

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Test
    fun `spring context text`() {
        assertNotNull(personRepository)
    }

    @Test
    fun `persists person correctly`() {
        val email = "test@test.de"
        val person = randomData<Person> {
            this.email = email
        }
        val personEntity = personRepository.save(person)
        assertTrue(personRepository.existsById(personEntity.uuid))
        assertEquals(email, person.email)
    }

}
