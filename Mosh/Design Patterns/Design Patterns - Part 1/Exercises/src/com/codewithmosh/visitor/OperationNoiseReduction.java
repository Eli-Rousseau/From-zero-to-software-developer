package com.codewithmosh.visitor;

import java.util.List;

public class OperationNoiseReduction implements Operation {
    @Override
    public void apply(FactSegment segment) {
        System.out.println("Noise reduction");
    }

    @Override
    public void apply(FormatSegment segment) {
        System.out.println("Noise reduction");
    }
}
