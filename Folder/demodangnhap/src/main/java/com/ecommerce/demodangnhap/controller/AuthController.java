package com.ecommerce.demodangnhap.controller;


import com.ecommerce.demodangnhap.entity.User;
import com.ecommerce.demodangnhap.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Hiển thị form
    @GetMapping("/register")
    public String registerPage(Model model){

        model.addAttribute("user", new User());

        return "register";
    }

    // Xử lý đăng ký
    @PostMapping("/register")
    public String registerUser(
            @ModelAttribute User user,
            Model model
    ){

        // Check username tồn tại
        if(userRepository.existsByUsername(
                user.getUsername()
        )){

            model.addAttribute(
                    "error",
                    "Username đã tồn tại"
            );

            return "register";
        }

        // Check email tồn tại
        if(userRepository.existsByEmail(
                user.getEmail()
        )){

            model.addAttribute(
                    "error",
                    "Email đã tồn tại"
            );

            return "register";
        }

        // Save vào MySQL
        userRepository.save(user);

        model.addAttribute(
                "success",
                "Đăng ký thành công"
        );

        return "register";
    }
}