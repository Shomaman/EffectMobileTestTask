package com.example.effectMobile.TestTask.service;

import com.example.effectMobile.TestTask.entity.BankCard;
import com.example.effectMobile.TestTask.DTO.BankCardDTO;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public BankCard createBankCard(BankCardDTO bankCardDTO){
        BankCard bankCard = new BankCard();
        //bankCard.setCardId();
        return bankCard;
    }
}
