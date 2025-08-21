package com.app.trip.controller;

import com.app.trip.service.UserService;
import com.app.trip.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired private UserService userService;


    @GetMapping("/login")
    public String showLoginForm() { return "user/login"; }


    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String pw, Model model) {
        if (userService.login(id, pw)) {
            return "redirect:/user/mypage";
        }
        model.addAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
        model.addAttribute("id", id); // 입력값 보존
        return "user/login";
    }

  
    @GetMapping("/signup")
    public String showSignupForm() { return "user/signup"; }

 
    @PostMapping("/signup")
    public String signup(
            @RequestParam String id,
            @RequestParam String pw,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            Model model) {

        String pwPattern = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,}$";
        if (!pw.matches(pwPattern)) {
            model.addAttribute("msg", "비밀번호는 영문, 숫자, 특수문자 8자 이상이어야 합니다.");
            model.addAttribute("id", id); model.addAttribute("name", name); model.addAttribute("email", email); model.addAttribute("phone", phone);
            return "user/signup";
        }
        boolean ok = userService.signup(id, pw, name, email, phone);
        if (!ok) {
            model.addAttribute("msg", "회원가입 실패! (아이디 중복 등)");
            model.addAttribute("id", id); model.addAttribute("name", name); model.addAttribute("email", email); model.addAttribute("phone", phone);
            return "user/signup";
        }
        model.addAttribute("msg", "회원가입이 완료되었습니다! 로그인해주세요.");
        return "user/login";
    }

 
    @GetMapping("/find")
    public String findForm() { return "user/find"; }

 
    @PostMapping("/findId")
    public String findId(@RequestParam String email, Model model) {
        User user = userService.findByEmail(email);
        if (user != null)
            model.addAttribute("findId", user.getUserId());
        else
            model.addAttribute("msg", "일치하는 정보가 없습니다.");
        return "user/find";
    }


    @PostMapping("/findPw")
    public String findPw(@RequestParam String id, @RequestParam String email, Model model) {
        boolean ok = userService.sendResetPasswordEmail(id, email); // 실서비스는 이메일 발송
        if (!ok)
            model.addAttribute("msg", "정보가 일치하지 않습니다.");
        else
            model.addAttribute("msg", "임시비밀번호가 이메일로 발송되었습니다.");
        return "user/find";
    }

  
    @GetMapping("/mypage")
    public String mypage() { return "user/mypage"; }
}
