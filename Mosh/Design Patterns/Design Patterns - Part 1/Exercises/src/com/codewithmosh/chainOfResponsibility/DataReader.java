package com.codewithmosh.chainOfResponsibility;

public class DataReader {
    public void read(String fileName) {
        Handler quickBooksHandler = new QuickBooksHandler(null);
        Handler numbersHandler = new NumbersHandler(quickBooksHandler);
        Handler excelHandler = new ExcelHandler(numbersHandler);
        excelHandler.handle(fileName);
    }
}
