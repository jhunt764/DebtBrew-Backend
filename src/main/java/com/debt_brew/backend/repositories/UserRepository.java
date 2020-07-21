package com.debt_brew.backend.repositories;

import com.debt_brew.backend.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByUsername(String Username);
}