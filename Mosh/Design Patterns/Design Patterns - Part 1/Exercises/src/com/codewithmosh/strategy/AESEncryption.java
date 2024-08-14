package com.codewithmosh.strategy;

public class AESEncryption implements EncryptionStrategy {
    @Override
    public void encryption(String message) {
        System.out.println("Encrypting message using AES");
    }
}
