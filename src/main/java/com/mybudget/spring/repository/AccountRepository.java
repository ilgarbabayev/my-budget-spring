package com.mybudget.spring.repository;

import com.mybudget.spring.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
