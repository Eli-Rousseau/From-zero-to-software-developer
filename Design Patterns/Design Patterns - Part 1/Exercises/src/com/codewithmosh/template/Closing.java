package com.codewithmosh.template;

public abstract class Closing {

    private Window window;

    public Closing(Window window) {
        this.window = window;
    }

    public void execute() {
        doExecute();
    }

    public abstract void doExecute();

}
