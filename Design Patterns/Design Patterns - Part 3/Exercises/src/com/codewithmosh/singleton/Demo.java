package com.codewithmosh.singleton;

import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        Logger logFile = Logger.getLogFile();
        logFile.write("Hello world");
    }
}
