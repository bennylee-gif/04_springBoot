package com.example.wonit.controller;

import com.example.wonit.dto.TransactionResponse;
import com.example.wonit.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/account/{accountId}")
    public List<TransactionResponse> findByAccountId(@PathVariable Integer accountId) {
        return transactionService.findByAccountId(accountId)
                .stream()
                .map(TransactionResponse::from)
                .toList();
    }

    @GetMapping("/select")
    public List<TransactionResponse> getTransactionByCategory(@RequestParam String category) {
        return transactionService.getTransactionByCategory(category)
                .stream()
                .map(TransactionResponse::from)
                .toList();
    }

    @GetMapping("/select/contains")
    public List<TransactionResponse> getTransactionByCategoryContaining(@RequestParam String category) {
        return transactionService.getTransactionByCategoryContaining(category)
                .stream()
                .map(TransactionResponse::from)
                .toList();
    }

    @GetMapping("/select/by-category-or-memo")
    public List<TransactionResponse> getTransactionByCategoryOrMemo(
            @RequestParam String category,
            @RequestParam String memo
    ) {
        return transactionService.getTransactionByCategoryOrMemo(category, memo)
                .stream()
                .map(TransactionResponse::from)
                .toList();
    }

    @GetMapping("/select2")
    public List<TransactionResponse> getTransactionByAmount(
            @RequestParam long minAmount,
            @RequestParam long maxAmount
    ) {
        return transactionService.getTransactionByAmount(minAmount, maxAmount)
                .stream()
                .map(TransactionResponse::from)
                .toList();
    }

}