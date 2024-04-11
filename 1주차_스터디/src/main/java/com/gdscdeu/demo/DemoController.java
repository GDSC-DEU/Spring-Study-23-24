package com.gdscdeu.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class DemoController {

    /**
     * 로그인 페이지 요청시 Loginform.html을 반환
     *
     * @return loginform.html
     */
    @GetMapping("/login")
    public String loginGet() {
        return "loginform.html";
    }

    /**
     * 로그인 요청시 로그인 정보를 출력 후 index.html로 리다이렉트
     *
     * @param username 유저 이름(아이디)
     * @param password 유저 비밀번호
     * @return index.html 리다이렉트
     */
    @PostMapping("/login.do")
    public String loginPost(@RequestParam String username, @RequestParam String password) {
        log.info("Username: {} Password: {}", username, password);
        return "redirect:/index.html";
    }
}
