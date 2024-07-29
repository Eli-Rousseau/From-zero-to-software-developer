package com.codewithmosh.strategy;

public class DESEncryption extends Encryption {
    @Override
    public void encrypt(String filename) {
        System.out.println("Encrypting message using DES");
    }
}
