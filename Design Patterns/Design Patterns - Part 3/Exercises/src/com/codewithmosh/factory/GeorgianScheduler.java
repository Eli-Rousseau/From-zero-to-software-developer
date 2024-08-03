package com.codewithmosh.factory;

public class GeorgianScheduler extends Scheduler {

    @Override
    protected Calendar getCalendar() {
        return new GeorgianCalender();
    }
}
