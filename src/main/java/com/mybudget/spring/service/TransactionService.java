package com.mybudget.spring.service;

import com.mybudget.spring.model.Category;
import com.mybudget.spring.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    Transaction getTransactionById(Integer id);
}
