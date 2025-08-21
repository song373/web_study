//// src/main/java/com/app/trip/controller/AdminController.java
//package com.app.controller.admin;
//
//import com.app.trip.service.AdminService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//    @Autowired private AdminService adminService;
//
//    @GetMapping("/login")
//    public String showLoginForm() { return "admin/login"; }
//
//    @PostMapping("/loginCheck")
//    public String loginCheck(@RequestParam String id, @RequestParam String pw, HttpSession session, Model model) {
//        if (adminService.isLocked(id)) {
//            model.addAttribute("msg", "5회 실패. 24시간 후 시도");
//            return "admin/login";
//        }
//        if (adminService.login(id, pw)) {
//            session.setAttribute("adminId", id);
//            return "redirect:/admin/dashboard";
//        } else {
//            model.addAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다.");
//            return "admin/login";
//        }
//    }
//
//    @GetMapping("/dashboard")
//    public String dashboard() { return "admin/dashboard"; }
//}
