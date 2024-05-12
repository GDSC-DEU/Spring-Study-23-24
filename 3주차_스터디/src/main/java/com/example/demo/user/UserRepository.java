package com.example.demo.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class UserRepository {
    ArrayList<User> users = new ArrayList<User>();

    /**
     * 사용자 저장
     * 
     * @param user 사용자 객체
     * @return 저장된 사용자 객체
     */
    public User save(User user) {
        users.add(user);
        return user;
    }

    /**
     * 이메일로 사용자 찾기
     * 
     * @param email 이메일
     * @return 사용자 객체
     */
    public Optional<User> findByEmail(String email) {
        Optional<User> user = Optional.empty();
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                user = Optional.of(u);
                break;
            }
        }
        return user;
    }

}
