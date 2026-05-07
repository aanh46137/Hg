package com.ecommerce.demodangnhap.repository;

import com.ecommerce.demodangnhap.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

    // Kiểm tra username tồn tại
    boolean existsByUsername(String username);

    // Kiểm tra email tồn tại
    boolean existsByEmail(String email);
}