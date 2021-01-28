package com.mybudget.spring.service.Impl;

import com.mybudget.spring.Exception.AccountNotFoundException;
import com.mybudget.spring.model.Account;
import com.mybudget.spring.repository.AccountRepository;
import com.mybudget.spring.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountById(Integer id) {
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id.toString()));
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccountByName(String name) {
        return accountRepository.getAccountByName(name).orElseThrow(() -> new AccountNotFoundException(name));
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
