package gdsc.deu.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class PersonJPARepository implements PersonRepository {

    private final EntityManagerFactory entityManagerFactory;

    @Autowired
    public PersonJPARepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Person save(Person person) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            log.error("Error while saving person", e);
        } finally {
            entityManager.close();
        }

        return person;
    }

    @Override
    public Optional<Person> findById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return Optional.ofNullable(entityManager.find(Person.class, id));
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Person person = entityManager.find(Person.class, id);
            entityManager.remove(person);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            log.error("Error while deleting person", e);
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<Person> findAll() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }
}
