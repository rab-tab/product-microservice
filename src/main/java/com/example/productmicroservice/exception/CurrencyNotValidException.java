package com.example.productmicroservice.exception;

public class CurrencyNotValidException extends RuntimeException {
    public CurrencyNotValidException(String s) {
        super(s);
    }
}