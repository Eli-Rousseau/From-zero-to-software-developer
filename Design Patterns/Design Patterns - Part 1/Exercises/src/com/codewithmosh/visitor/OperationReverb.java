package com.codewithmosh.visitor;

import java.util.List;

public class OperationReverb implements Operation {
    @Override
    public void apply(FactSegment segment) {
        System.out.println("Add reverb");
    }

    @Override
    public void apply(FormatSegment segment) {
        System.out.println("Add reverb");
    }
}
