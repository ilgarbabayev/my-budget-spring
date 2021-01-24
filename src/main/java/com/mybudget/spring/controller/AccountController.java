package com.mybudget.spring.controller;

import com.mybudget.spring.model.Account;
import com.mybudget.spring.service.Impl.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/account")
@AllArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountService;

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Integer id){
        return accountService.getAccountById(id);
    }

    @GetMapping("/{name}")
    public Account getAccount(@PathVariable String name){
        return accountService.getAccountByName(name);
    }
}
