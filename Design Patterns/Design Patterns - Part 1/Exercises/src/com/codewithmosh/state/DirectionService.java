package com.codewithmosh.state;

public class DirectionService {
    private TravelMode travelMode;

    public int getEta() {
        return travelMode.getEta();
    }

    public int getDirection() {
        return travelMode.getDirection();
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
    }
}
