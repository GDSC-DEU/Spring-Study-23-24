package com.example.demo.auth;

import com.example.demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 회원가입 API
     * 
     * @param email 아이디
     * @param password 비밀번호
     * @param name 이름
     * @return 가입된 사용자 객체
     */
    @PostMapping("/signup")
    public User signUp(@RequestParam String email, @RequestParam String password,
            @RequestParam String name) {
        return authService.signup(email, password, name);
    }

    /**
     * 로그인 API
     * 
     * @param email 아이디
     * @param password 비밀번호
     * @return 사용자 객체
     */
    @PostMapping("/signin")
    public User signIn(@RequestParam String email, @RequestParam String password) {
        return authService.signin(email, password);
    }
}
