package com.codewithmosh.factory;

import java.util.Date;

public abstract class Scheduler {

    public void schedule(Event event) {
        var today = new Date();
        getCalendar().addEvent(event, today);
    }

    protected abstract Calendar getCalendar();
}
