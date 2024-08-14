package com.codewithmosh.singleton;

public class Logger {

    private static Logger logFile = new Logger();

    private Logger() {}

    public static Logger getLogFile() {
        return logFile;
    }

    public void write(String message) {
        System.out.println("Writing a message to the log.");
    }
}
