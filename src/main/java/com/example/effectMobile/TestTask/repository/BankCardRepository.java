package com.example.effectMobile.TestTask.repository;

import com.example.effectMobile.TestTask.entity.BankCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCardRepository extends JpaRepository<BankCard, Long> {
}
