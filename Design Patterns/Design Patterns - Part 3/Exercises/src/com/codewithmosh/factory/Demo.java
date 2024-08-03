package com.codewithmosh.factory;

import java.util.Date;

public class Demo {
    public static void show() {
        var event = new Event();

        var georgianScheduler = new GeorgianScheduler();
        georgianScheduler.schedule(event);

        var arabianScheduler = new ArabianScheduler();
        arabianScheduler.schedule(event);
    }
}
