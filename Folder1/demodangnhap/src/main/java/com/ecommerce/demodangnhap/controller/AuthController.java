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

    // Hiển thị form login
    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }

    // Xử lý login
    @PostMapping("/login")
    public String loginUser(

            @RequestParam String username,

            @RequestParam String password,

            Model model
    ){

        // Tìm trong MySQL
        User user =
                userRepository
                        .findByUsernameAndPassword(
                                username,
                                password
                        );

        // Sai tài khoản
        if(user == null){

            model.addAttribute(
                    "error",
                    "Sai tài khoản hoặc mật khẩu"
            );

            return "login";
        }

        // Thành công
        model.addAttribute(
                "success",
                "Đăng nhập thành công"
        );

        return "login";
    }
}