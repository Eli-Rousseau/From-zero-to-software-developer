package com.codewithmosh.adapter;

import com.codewithmosh.adapter.Gmail.GmailClient;

public class Demo {

    public static void main(String[] args) {
        var clients = new EmailClient();
        var gmailClient = new GmailAdapter(new GmailClient());
        clients.addProvider(gmailClient);
        clients.downloadEmails();
    }

}
