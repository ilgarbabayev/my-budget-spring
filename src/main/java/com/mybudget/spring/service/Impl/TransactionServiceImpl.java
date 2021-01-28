package com.mybudget.spring.service.Impl;

import com.mybudget.spring.Exception.TransactionNotFoundException;
import com.mybudget.spring.model.Transaction;
import com.mybudget.spring.repository.TransactionRepository;
import com.mybudget.spring.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id.toString()));
    }

}
