package com.codewithmosh.state;

import com.codewithmosh.state.DirectionService;
import com.codewithmosh.state.Walking;

public class Demo {

    public static void main(String[] args) {
        var service = new DirectionService();
        System.out.println(service.getEta(new Walking()));
        System.out.println(service.getDirection(new Walking()));
    }

}
