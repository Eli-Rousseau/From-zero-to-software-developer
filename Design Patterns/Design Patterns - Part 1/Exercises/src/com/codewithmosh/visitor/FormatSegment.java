package com.codewithmosh.visitor;

public class FormatSegment implements Segment {
    @Override
    public void accept(Operation operation) {
        operation.apply(this);
    }
}
