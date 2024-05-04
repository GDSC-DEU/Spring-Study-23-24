package com.example.demo;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class MemoController {
    /*
    1. 메모 페이지 요청시 title(제목)과 content(내용)의 값을 받아서 model 객체에 등록
    2. memo 뷰 템플릿 반환 (model에 등록된 변수들도 넘겨줌)
     */
    @GetMapping("/memo")
    public String getAllMemos(Model model, @RequestParam String title, @RequestParam String content){
        LocalDateTime date = LocalDateTime.now();
        model.addAttribute("title", title);
        model.addAttribute("content", content);
        model.addAttribute("date", date);
        return "memo";
    }
}
