package com.codewithmosh.strategy;

public class Demo {

    public static void main(String[] args) {
        var encryption = new AESEncryption();
        var chat = new ChatClient(encryption);
        chat.send("This is a message");
    }
}
