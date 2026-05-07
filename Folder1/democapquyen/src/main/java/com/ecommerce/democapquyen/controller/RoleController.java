package com.ecommerce.democapquyen.controller;



import com.ecommerce.democapquyen.entity.UserRole;

import com.ecommerce.democapquyen.repository.UserRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
public class RoleController {

    @Autowired
    private UserRoleRepository userRoleRepository;

    // Hiển thị form
    @GetMapping("/role")
    public String rolePage(Model model){

        model.addAttribute(
                "userRole",
                new UserRole()
        );

        return "role";
    }

    // Save database
    @PostMapping("/role")
    public String saveRole(

            @ModelAttribute UserRole userRole,

            Model model
    ){

        // Save MySQL
        userRoleRepository.save(userRole);

        model.addAttribute(
                "success",
                "Lưu quyền thành công"
        );

        model.addAttribute(
                "userRole",
                new UserRole()
        );

        return "role";
    }
}