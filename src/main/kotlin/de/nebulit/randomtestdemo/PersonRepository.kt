package de.nebulit.randomtestdemo

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate
import java.util.*
import javax.validation.constraints.*
import kotlin.math.min

@Entity
class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    lateinit var uuid: UUID
    var street: String? = null
    var houseNumber: String? = null
    @Pattern(regexp = "[0-9]{5}")
    var zip: String? = null
    var city: String? = null
}

@Entity
class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    lateinit var uuid: UUID
    var name:String? = null
    @Past
    var birthday: LocalDate? = null
    @Email
    var email: String? = null
    @ManyToOne(cascade = [CascadeType.ALL])
    var address: Address? = null
}

interface PersonRepository : JpaRepository<Person, UUID>
