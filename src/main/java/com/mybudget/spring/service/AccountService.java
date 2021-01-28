package com.mybudget.spring.service;

import com.mybudget.spring.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getAccountById(Integer id);
    Account getAccountByName(String name);
    void save(Account account);
}
