package com.mybudget.spring.controller;

import com.mybudget.spring.model.Account;
import com.mybudget.spring.service.Impl.AccountServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/account")
@AllArgsConstructor
public class AccountController {
    private final AccountServiceImpl accountService;

    @GetMapping("/{all}")
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

    @PostMapping
    public ResponseEntity<Void> createAccount(@RequestBody Account account){
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
