package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("studyHomeController") // 빈 이름을 "studyHomeController"로 명확히 지정
public class HomeController {

    @RequestMapping("/") // 이 매핑은 다른 "/" 매핑과 충돌할 수 있습니다.
    public String home() {
        return "mainpage";
    }
}