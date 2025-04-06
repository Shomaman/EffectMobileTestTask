package com.example.effectMobile.TestTask.DTO;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record BankCardDTO(

        @NotBlank(message = "Имя держателя карты не может быть пустым")
        @Size(message = "Имя держателя карты должно быть от {min} до {max} символов", min = 2, max = 200)
        String cardOwner,

        @NotNull(message = "Заполните срок действия карты")
        @Future(message = "Срок действия должен быть до даты, которая еще не наступила")
        LocalDate dateOfExpiry) {
}