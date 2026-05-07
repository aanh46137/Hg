package com.ecommerce.demodanhgia.controller;


import com.ecommerce.demodanhgia.entity.Review;

import com.ecommerce.demodanhgia.repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    // Hiển thị form + list
    @GetMapping("/review")
    public String reviewPage(Model model){

        model.addAttribute(
                "review",
                new Review()
        );

        // Lấy toàn bộ review
        model.addAttribute(
                "reviews",
                reviewRepository.findAll()
        );

        return "review";
    }

    // Save review
    @PostMapping("/review")
    public String saveReview(

            @ModelAttribute Review review
    ){

        // Save MySQL
        reviewRepository.save(review);

        return "redirect:/review";
    }
}