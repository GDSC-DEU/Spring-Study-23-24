# JDBC, JPA, Spring Data Jpa, ORM에 대한 스터디 진행

## JDBC

### JDBC란?

- Java Database Connectivity의 약자로, 자바 프로그램 내에서 DB와 연결할 수 있게 해주는 자바 API이다.
- JDBC는 자바 프로그램 내에서 SQL문을 실행할 수 있게 해주며, SQL문 실행 결과를 받아올 수 있다.

### JDBC 사용 방법

1. JDBC 드라이버 로드
2. DB 연결
3. SQL문 실행
4. SQL문 실행 결과 받아오기
5. DB 연결 해제
6. JDBC 드라이버 언로드
7. 예외 처리
8. 자원 해제

## JPA

### JPA란?

- Java Persistence API의 약자로, 자바 진영의 ORM 기술 표준이다.
- JPA는 자바 객체와 DB 테이블 간의 매핑을 처리해주는 프레임워크이다.
- JPA를 사용하면 객체 지향적인 코드로 데이터베이스를 다룰 수 있다.
- JPA는 ORM을 사용하기 위한 인터페이스를 모아둔 것이다.
- JPA는 ORM을 사용하기 위한 표준 인터페이스를 제공하며, 이를 구현한 구현체들이 존재한다.

### JPA 사용 방법

1. JPA 설정
2. 엔티티 클래스 생성
3. 엔티티 매니저 팩토리 생성
4. 엔티티 매니저 생성
5. 트랜잭션 관리
6. 엔티티 매니저 팩토리 종료
7. 예외 처리
8. 자원 해제

## Spring Data Jpa

### Spring Data Jpa란?

- Spring Data Jpa는 스프링에서 JPA를 쉽게 사용할 수 있도록 도와주는 프레임워크이다.
- Spring Data Jpa는 JPA를 사용하기 위한 인터페이스를 제공하며, 이를 구현한 구현체들이 존재한다.
- Spring Data Jpa는 JPA를 사용하기 위한 반복적인 코드를 줄여준다.

### 사용 방법

1. 의존성 추가
2. Repository 인터페이스 생성
3. Repository 인터페이스 구현
4. Repository 인터페이스 사용

```java
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
}
```

```java

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findUserByName(String name) {
        return userRepository.findByName(name);
    }
}
```

## ORM

### ORM이란?

- Object-Relational Mapping의 약자로, 객체와 관계형 데이터베이스 간의 매핑을 처리해주는 프레임워크이다.
- ORM을 사용하면 객체 지향적인 코드로 데이터베이스를 다룰 수 있다.
- ORM은 객체와 관계형 데이터베이스 간의 매핑을 처리해주는 프레임워크이다.
- 

