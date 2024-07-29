package com.codewithmosh.template;

public class Window {

    private String type;

    public Window(String type) {
        this.type = type;
    }

    public void close() {


        //TODO: custom windows may need to execute some code before the window
        // is closed.

        System.out.println("Removing the window from the screen");

        //TODO: custom windows may need to execute some code after the window
        // is closed.
    }
}
