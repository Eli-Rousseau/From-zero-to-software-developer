package com.codewithmosh.chainOfResponsibility;

public class ExcelHandler extends Handler {
    public ExcelHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(String fileName) {
        if (fileName.endsWith(".xls")) {
            System.out.println("Reading data from an Excel spreadsheet.");
        }
        else if (this.getNextHandler() != null) {
            this.getNextHandler().handle(fileName);
        }
        else {
            throw new UnsupportedOperationException();
        }
    }
}
