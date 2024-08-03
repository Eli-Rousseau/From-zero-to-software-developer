package com.codewithmosh.factory;

import java.util.Date;

public class GeorgianCalender implements Calendar {

    @Override
    public void addEvent(Event event, Date date) {
        System.out.println("Event added to Georgian Calender");
    }
}
