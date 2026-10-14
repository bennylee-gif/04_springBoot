package com.example.wonit.repository;

import com.example.wonit.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountId(Integer accountId);
    List<Transaction> findByCategory(String category); // 완전 일치
    List<Transaction> findByCategoryContaining(String category); // 일부 일치
    List<Transaction> findByCategoryContainingOrMemoContaining(
            String category,
            String memo
    );
    List<Transaction> findByAmountBetween(long minAmount, long maxAmount);
}