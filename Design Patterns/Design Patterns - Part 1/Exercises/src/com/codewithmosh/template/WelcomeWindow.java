package com.codewithmosh.template;

public class WelcomeWindow extends Window {
    @Override
    protected void beforeClosing() {
        System.out.println("The welcome window is closing ..");
    }

    @Override
    protected void afterClosing() {
        System.out.println("The welcome window is successfully closed.");
    }
}
