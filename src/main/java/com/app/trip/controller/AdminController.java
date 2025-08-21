package com.app.trip.controller;

import com.app.trip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired private AdminService adminService;


    @GetMapping("/login")
    public String showLoginForm() { 
    	return "admin/login";
    	}

    
    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String pw, Model model) {
        if (adminService.isLocked(id)) {
            model.addAttribute("msg", "5회 실패. 24시간 잠금");
            model.addAttribute("id", id);
            return "admin/login";
        }
        if (adminService.login(id, pw)) {
            return "redirect:/admin/dashboard";
        }
        model.addAttribute("msg", "아이디 또는 비밀번호 오류. 5회 실패시 24시간 잠금");
        model.addAttribute("id", id);
        return "admin/login";
    }

   
    @GetMapping("/signup")
    public String showSignupForm() {
    	return "admin/signup"; 
    	}


    @PostMapping("/signup")
    public String signup(@RequestParam String id, @RequestParam String pw, @RequestParam String name, Model model) {
        String pwPattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$";
        if (!pw.matches(pwPattern)) {
            model.addAttribute("msg", "비밀번호는 영문, 숫자, 특수문자 8자 이상이어야 합니다.");
            model.addAttribute("id", id); model.addAttribute("name", name);
            return "admin/signup";
        }
        boolean ok = adminService.signup(id, pw, name);
        if (!ok) {
            model.addAttribute("msg", "회원가입 실패! (아이디 중복 등)");
            model.addAttribute("id", id); model.addAttribute("name", name);
            return "admin/signup";
        }
        model.addAttribute("msg", "회원가입이 완료되었습니다! 로그인해주세요.");
        return "admin/login";
    }

   
    @GetMapping("/dashboard")
    public String dashboard() {
    	return "admin/dashboard"; 
  
    }
}
