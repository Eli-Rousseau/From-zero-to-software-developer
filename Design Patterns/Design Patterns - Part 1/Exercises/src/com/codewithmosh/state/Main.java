package com.codewithmosh.state;

public class Main {
    public static void main(String[] args) {
        var directionService = new DirectionService();
        directionService.setTravelMode(new BicyclingMode());
        directionService.getEta();
        directionService.getDirection();
    }
}
