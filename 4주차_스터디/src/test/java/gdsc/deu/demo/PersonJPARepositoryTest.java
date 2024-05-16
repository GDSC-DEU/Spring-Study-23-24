package gdsc.deu.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PersonJPARepositoryTest {

    @Autowired
    private PersonJPARepository personJPARepository;

    @Test
    void save() {
        Person person = Person.builder()
                .age(25)
                .name("Namju")
                .surname("Kim")
                .build();

        Person savedPerson = personJPARepository.save(person);
        Assertions.assertNotNull(savedPerson);
    }

    @Test
    void findById() {
        Long id = 1L;
        Optional<Person> person = personJPARepository.findById(id);
        Assertions.assertTrue(person.isPresent());
    }

    @Test
    @Transactional
    void deleteById() {
        Long id = 1L;
        personJPARepository.deleteById(id);

        Optional<Person> person = personJPARepository.findById(id);
    }

    @Test
    void findAll() {
        List<Person> people = personJPARepository.findAll();
        Assertions.assertFalse(people.isEmpty());
    }
}
