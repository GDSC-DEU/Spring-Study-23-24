package gdsc.deu.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PersonJDBCRepositoryTest {

    @Autowired
    private PersonJDBCRepository personJDBCRepository;

    @Test
    void save() {
        Person person = Person.builder()
                .id(null)
                .name("John")
                .surname("Doe")
                .age(50)
                .build();
        Person savedPerson = personJDBCRepository.save(person);
        Assertions.assertNotNull(savedPerson);
    }

    @Test
    void findById() {
        Long id = 2L;
        Optional<Person> person = personJDBCRepository.findById(id);
        Assertions.assertTrue(person.isPresent());
    }

    @Test
    @Transactional
    void deleteById() {
        Long id = 5L;
        personJDBCRepository.deleteById(id);

        Optional<Person> person = personJDBCRepository.findById(id);
        Assertions.assertTrue(person.isEmpty());
    }

    @Test
    void findAll() {
        List<Person> people = personJDBCRepository.findAll();
        Assertions.assertFalse(people.isEmpty());
    }
}
