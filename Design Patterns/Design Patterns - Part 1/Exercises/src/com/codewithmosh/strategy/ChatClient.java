package com.codewithmosh.strategy;

public class ChatClient {
    private EncryptionStrategy encryptionAlgorithm;

    public ChatClient(EncryptionStrategy encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public void send(String message) {
        encryptionAlgorithm.encryption(message);
        System.out.println("Sending the encrypted message...");
    }
}
