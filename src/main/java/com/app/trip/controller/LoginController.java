//package com.app.trip.controller;
//
//import com.app.trip.service.UserService;
//import com.app.trip.service.AdminService;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class LoginController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private AdminService adminService;
//
//    @PostMapping("/user/login")
//    public String userLogin(@RequestParam String id, @RequestParam String pw, HttpServletRequest request) {
//        if (userService.authenticate(id, pw)) {
//            request.getSession().setAttribute("userId", id);
//            return "redirect:/user/dashboard";
//        }
//        return "redirect:/login?error=true";
//    }
//
//    @PostMapping("/admin/login")
//    public String adminLogin(@RequestParam String id, @RequestParam String pw, HttpServletRequest request) {
//        if (adminService.login(id, pw)) {
//            request.getSession().setAttribute("adminId", id);
//            return "redirect:/admin/dashboard";
//        }
//        return "redirect:/admin-login?error=true";
//    }
//}