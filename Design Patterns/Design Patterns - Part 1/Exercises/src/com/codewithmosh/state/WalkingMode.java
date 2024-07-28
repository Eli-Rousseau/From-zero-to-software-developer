package com.codewithmosh.state;

public class WalkingMode implements TravelMode{
    @Override
    public int getEta() {
        System.out.println("Calculating ETA (walking)");
        return 4;
    }

    @Override
    public int getDirection() {
        System.out.println("Calculating Direction (walking)");
        return 4;
    }
}
