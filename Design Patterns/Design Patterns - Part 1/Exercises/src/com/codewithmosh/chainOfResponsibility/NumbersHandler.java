package com.codewithmosh.chainOfResponsibility;

public class NumbersHandler extends Handler {
    public NumbersHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(String fileName) {
        if (fileName.endsWith(".numbers")) {
            System.out.println("Reading data from a Numbers spreadsheet.");
        }
        else if (this.getNextHandler() != null) {
            this.getNextHandler().handle(fileName);
        }
        else {
            throw new UnsupportedOperationException();
        }
    }
}
