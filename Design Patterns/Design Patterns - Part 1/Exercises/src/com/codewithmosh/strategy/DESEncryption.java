package com.codewithmosh.strategy;

public class DESEncryption implements EncryptionStrategy {
    @Override
    public void encryption(String message) {
        System.out.println("Encrypting message using DES");
    }
}
