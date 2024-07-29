package com.codewithmosh.strategy;

public class AESEncryption extends Encryption{
    @Override
    public void encrypt(String filename) {
        System.out.println("Encrypting message using AES");
    }
}
