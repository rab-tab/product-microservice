package com.example.productmicroservice.exception;

public class OfferNotValidException extends RuntimeException {
    public OfferNotValidException(String s) {
        super(s);
    }
}