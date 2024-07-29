package com.codewithmosh.strategy;

public class Main {
    public static void main(String[] args) {
        var chat = new ChatClient(new AESEncryption());
        chat.send("This is a file");
    }
}
