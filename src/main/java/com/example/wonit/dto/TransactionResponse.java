package com.example.wonit.dto;

import com.example.wonit.model.Transaction;

import java.time.LocalDateTime;

public record TransactionResponse(
        Long txId,
        Integer accountId,
        Long transferId,
        String txType,
        long amount,
        long balanceAfter,
        String category,
        String memo,
        String counterparty,
        LocalDateTime txDatetime
) {
    public static TransactionResponse from(Transaction transaction) {
        return new TransactionResponse(
                transaction.getTxId(),
                transaction.getAccountId(),
                transaction.getTransferId(),
                transaction.getTxType(),
                transaction.getAmount(),
                transaction.getBalanceAfter(),
                transaction.getCategory(),
                transaction.getMemo(),
                transaction.getCounterparty(),
                transaction.getTxDatetime()
        );
    }
}