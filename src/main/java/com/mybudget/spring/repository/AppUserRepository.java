package com.mybudget.spring.repository;

import com.mybudget.spring.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findAppUserByUsername(String username);
}
