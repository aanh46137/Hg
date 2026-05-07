package com.ecommerce.democapquyen.repository;


import com.ecommerce.democapquyen.entity.UserRole;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository
        extends JpaRepository<UserRole, Long> {
}