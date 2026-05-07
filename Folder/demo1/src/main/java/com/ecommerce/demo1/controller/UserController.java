package com.ecommerce.demo1.controller;

import com.ecommerce.demo1.entity.User;
import com.ecommerce.demo1.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    
    @GetMapping("/add-user")
    public String showForm(Model model) {

        model.addAttribute("user", new User());

        return "add-user";
    }

    
    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute User user) {

        userRepository.save(user);

        return "redirect:/users";
    }
    @GetMapping("/users")
public String listUsers(Model model){

    model.addAttribute("users", userRepository.findAll());

    return "user-list";
}

}

