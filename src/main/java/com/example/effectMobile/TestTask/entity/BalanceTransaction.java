package com.example.effectMobile.TestTask.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table(name = "balance_transactions")
@Entity
public class BalanceTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "type_change_balance", nullable = false)
    TypeChangeBalance typeChangeBalance;

    @Column(name = "amount_change_balance", nullable = false)
    BigDecimal amountChangeBalance;

    @Column(name = "balance_change_time", nullable = false)
    LocalDateTime balanceChangeTime;

    public BigDecimal addMoney(BigDecimal currentBalance){
       return currentBalance.add(amountChangeBalance);
    }

    public BigDecimal subTractMoney(BigDecimal currentBalance){
        return currentBalance.subtract(amountChangeBalance);
    }
}
