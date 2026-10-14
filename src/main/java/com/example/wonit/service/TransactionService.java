package com.example.wonit.service;

import com.example.wonit.model.Transaction;
import com.example.wonit.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findByAccountId(Integer accountId) {
        return transactionRepository.findByAccountId(accountId);
    }
    public List<Transaction> getTransactionByCategory(String category) {
        return transactionRepository.findByCategory(category);
    }

    public List<Transaction> getTransactionByCategoryContaining(String category) {
        return transactionRepository.findByCategoryContaining(category);
    }

    public List<Transaction> getTransactionByCategoryOrMemo(String category, String memo) {
        return transactionRepository.findByCategoryContainingOrMemoContaining(category, memo);
    }

    public List<Transaction> getTransactionByAmount(long minAmount, long maxAmount) {
        return transactionRepository.findByAmountBetween(minAmount, maxAmount);
    }

}