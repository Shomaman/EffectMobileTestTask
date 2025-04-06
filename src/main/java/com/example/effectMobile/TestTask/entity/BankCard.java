package com.example.effectMobile.TestTask.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bank_cards")
public class BankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id", nullable = false, unique = true)
    private Long cardId;

    @Column(name = "card_owner", nullable = false,length = 200)
    String cardOwner;

    @Column(name = "date_of_expiry", nullable = false)
    LocalDate dateOfExpiry;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_bank_card", nullable = false, length = 100)
    StatusBankCard statusBankCard;

    @Column(name = "balance", nullable = false)
    BigDecimal balance;

    @Column(name="history_transactions", nullable = false)
    List<Double> historyTransactions;

    public BankCard() {
    }

    public BankCard(Long cardId, String cardOwner, LocalDate dateOfExpiry, StatusBankCard statusBankCard,
                    BigDecimal balance, List<Double> historyTransactions) {
        this.cardId = cardId;
        this.cardOwner = cardOwner;
        this.dateOfExpiry = dateOfExpiry;
        this.statusBankCard = statusBankCard;
        this.balance = balance;
        this.historyTransactions = historyTransactions;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardOwner() {
        return cardOwner;
    }

    public void setCardOwner(String cardOwner) {
        this.cardOwner = cardOwner;
    }

    public LocalDate getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(LocalDate dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public StatusBankCard getStatusBankCard() {
        return statusBankCard;
    }

    public void setStatusBankCard(StatusBankCard statusBankCard) {
        this.statusBankCard = statusBankCard;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Double> getHistoryTransactions() {
        return historyTransactions;
    }

    public void setHistoryTransactions(List<Double> historyTransactions) {
        this.historyTransactions = historyTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankCard bankCard = (BankCard) o;
        return Objects.equals(cardId, bankCard.cardId) && Objects.equals(cardOwner, bankCard.cardOwner) && Objects.equals(dateOfExpiry, bankCard.dateOfExpiry) && statusBankCard == bankCard.statusBankCard && Objects.equals(balance, bankCard.balance) && Objects.equals(historyTransactions, bankCard.historyTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, cardOwner, dateOfExpiry, statusBankCard, balance, historyTransactions);
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "cardId=" + cardId +
                ", cardOwner='" + cardOwner + '\'' +
                ", dateOfExpiry=" + dateOfExpiry +
                ", statusBankCard=" + statusBankCard +
                ", balance=" + balance +
                ", historyTransactions=" + historyTransactions +
                '}';
    }
}
