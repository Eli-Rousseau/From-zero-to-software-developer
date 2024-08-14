package com.codewithmosh.visitor;

public class FactSegment implements Segment {
    @Override
    public void accept(Operation operation) {
        operation.apply(this);
    }
}
