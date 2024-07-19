package com.uicontrol;

import java.util.Objects;

public class Point {

    // Initialize the class fields
    private int x;
    private int y;

    // Initialize the class constructor method
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Initialize override for the inherited equals method
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        var other = (Point)obj;
        return other.x == this.x && other.y == this.y;
    }

    // Initialize override for the inherited hashcode method
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
