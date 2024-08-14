package com.codewithmosh.template;

public abstract class Window {
    public void close() {
        //TODO: custom windows may need to execute some code before the window
        // is closed.
        beforeClosing();

        System.out.println("Removing the window from the screen");

        //TODO: custom windows may need to execute some code after the window
        // is closed.
        afterClosing();
    }

    protected abstract void beforeClosing();

    protected  abstract void afterClosing();
}
