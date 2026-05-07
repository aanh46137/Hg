package com.ecommerce.demo1.repository;



import com.ecommerce.demo1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}