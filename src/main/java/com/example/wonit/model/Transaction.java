package com.example.wonit.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "account_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tx_id")
    private Long txId;

    @Column(name = "account_id", nullable = false)
    private Integer accountId;

    @Column(name = "transfer_id")
    private Long transferId;

    @Column(name = "tx_type", nullable = false, length = 10)
    private String txType;

    @Column(nullable = false)
    private long amount;

    @Column(name = "balance_after", nullable = false)
    private long balanceAfter;

    @Column(length = 20)
    private String category;

    @Column(length = 100)
    private String memo;

    @Column(length = 50)
    private String counterparty;

    @Column(name = "tx_datetime", nullable = false)
    private LocalDateTime txDatetime;
}
