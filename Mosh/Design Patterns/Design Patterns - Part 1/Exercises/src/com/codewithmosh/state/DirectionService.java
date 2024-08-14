package com.codewithmosh.state;

public class DirectionService {
    private TravelMode travelMode;

    public int getEta(TravelMode mode) {
        return mode.getEta();
    }

    public int getDirection(TravelMode mode) {
        return mode.getDirection();
    }

    public TravelMode getTravelMode() {
        return travelMode;
    }

    public void setTravelMode(TravelMode travelMode) {
        this.travelMode = travelMode;
    }
}
