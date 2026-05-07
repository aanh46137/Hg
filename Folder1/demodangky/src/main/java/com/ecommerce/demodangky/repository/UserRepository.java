package com.ecommerce.demodangky.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.demodangky.entity.User;

public interface UserRepository
        extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}