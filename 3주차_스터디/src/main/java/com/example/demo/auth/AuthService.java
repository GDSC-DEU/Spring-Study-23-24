package com.example.demo.auth;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 회원가입 로직
     * 
     * <p>
     * 회원가입 시 비밀번호를 암호화하여 저장한다.
     * </p>
     * 
     * @param email 이메일
     * @param password 비밀번호
     * @param name 이름
     * @return 가입된 사용자 객체
     */
    public User signup(String email, String password, String name) {
        User newUser = new User(name, email, password);
        newUser.setPassword(encodePassword(password));
        return userRepository.save(newUser);
    }

    /**
     * 로그인 로직
     * 
     * <p>
     * 이메일로 사용자를 찾고, 비밀번호를 검증한다.
     * </p>
     * 
     * @param email 이메일
     * @param password 비밀번호
     * @return 사용자 객체
     */
    public User signin(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("가입되지 않은 이메일입니다."));

        if (!checkPassword(password, user.getPassword())) {
            throw new RuntimeException("잘못된 비밀번호입니다.");
        }

        return user;
    }

    private String encodePassword(String raw) {
        // TODO: 비밀번호 암호화 로직
        return raw;
    }

    private boolean checkPassword(String raw, String encoded) {
        // TODO: 비밀번호 검증 로직
        return raw.equals(encoded);
    }
}
