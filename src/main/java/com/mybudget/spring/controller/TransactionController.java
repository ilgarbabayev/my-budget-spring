package com.mybudget.spring.controller;

import com.mybudget.spring.model.Category;
import com.mybudget.spring.model.Transaction;
import com.mybudget.spring.service.Impl.CategoryServiceImpl;
import com.mybudget.spring.service.Impl.TransactionServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/transaction")
@AllArgsConstructor
public class TransactionController {
    private final TransactionServiceImpl transactionService;

    @GetMapping("/{all}")
    public List<Transaction> getAllCategories(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getCategory(@PathVariable Integer id){
        return transactionService.getTransactionById(id);
    }

}
