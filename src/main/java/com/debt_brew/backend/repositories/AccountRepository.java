package com.debt_brew.backend.repositories;

import java.util.Optional;

import com.debt_brew.backend.models.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findById(Integer id);
}