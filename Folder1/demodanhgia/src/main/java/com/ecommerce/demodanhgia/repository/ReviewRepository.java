package com.ecommerce.demodanhgia.repository;



import com.ecommerce.demodanhgia.entity.Review;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository
        extends JpaRepository<Review, Long> {
}