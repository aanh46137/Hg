package com.ecommerce.demodangnhap.repository;

import com.ecommerce.demodangnhap.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(
            String username,
            String password
    );
}
