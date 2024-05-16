package gdsc.deu.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonDataJpaRepository extends PersonRepository, JpaRepository<Person, Long> {
    /**
     * 사람을 저장한다.
     *
     * @param person 저장할 사람
     * @return 저장된 사람
     */
    Person save(Person person);

    /**
     * id로 사람을 찾는다.
     *
     * @param id 찾을 사람의 id
     * @return id에 해당하는 사람
     */
    Optional<Person> findById(Long id);

    /**
     * 사람을 삭제한다.
     *
     * @param id 삭제할 사람의 id
     */
    void deleteById(Long id);


    /**
     * 모든 사람을 찾는다.
     *
     * @return 모든 사람
     */
    List<Person> findAll();
}
