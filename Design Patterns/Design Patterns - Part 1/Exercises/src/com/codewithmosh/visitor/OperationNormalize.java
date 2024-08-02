package com.codewithmosh.visitor;

import java.util.List;

public class OperationNormalize implements Operation {
    @Override
    public void apply(FactSegment segment) {
        System.out.println("Noise normalization");
    }

    @Override
    public void apply(FormatSegment segment) {
        System.out.println("Noise normalization");
    }
}
