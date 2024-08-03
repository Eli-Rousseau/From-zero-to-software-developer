package com.codewithmosh.factory;

public class ArabianScheduler extends Scheduler {
    @Override
    protected Calendar getCalendar() {
        return new ArabianCalender();
    }
}
