package com.codewithmosh.chainOfResponsibility;

public class QuickBooksHandler extends Handler {
    public QuickBooksHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(String fileName) {
        if (fileName.endsWith(".qbw")) {
            System.out.println("Reading data from a QuickBooks file.");
        }
        else if (this.getNextHandler() != null) {
            this.getNextHandler().handle(fileName);
        }
        else {
            throw new UnsupportedOperationException();
        }
    }
}
