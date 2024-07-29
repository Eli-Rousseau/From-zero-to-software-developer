package com.codewithmosh.strategy;

public class ChatClient {
    private Encryption encryptionAlgorithm;

    public ChatClient(Encryption encryptionAlgorithm) {
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public void send(String filename) {
        encryptionAlgorithm.encrypt(filename);
        System.out.println("Sending the encrypted message...");
    }
}
