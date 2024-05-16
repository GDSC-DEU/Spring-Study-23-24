package gdsc.deu.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonDataJpaRepository personDataJpaRepository;

    @Test
    void save() {
        Person person = Person.builder()
                .name("gang")
                .surname("kim")
                .age(25)
                .build();

        Person savedPerson = personDataJpaRepository.save(person);
        Assertions.assertNotNull(savedPerson);
    }

    @Test
    void findById() {
        Long id = 2L;
        Person person = personDataJpaRepository.findById(id).get();
        Assertions.assertNotNull(person);
    }

    @Test
    @Transactional
    void deleteById() {
        // Given
        Long id = 1L;

        // When
        personDataJpaRepository.deleteById(id);

        // Then
        Assertions.assertTrue(personDataJpaRepository.findById(id).isEmpty());
    }

    @Test
    void findAll() {

        List<Person> people = personDataJpaRepository.findAll();

        Assertions.assertFalse(people.isEmpty());
    }
}
