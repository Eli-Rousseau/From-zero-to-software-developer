package com.codewithmosh.visitor;

import java.util.List;

public interface Operation {
    void apply(FactSegment segment);
    void apply(FormatSegment segment);
}
