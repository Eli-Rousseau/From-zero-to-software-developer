package com.codewithmosh.iterator;

import java.util.List;

public class DynamicArrayIterator implements Iterator {

    private List iteratable;
    private int indexInIteratable = 0;

    public DynamicArrayIterator(List iteratable) {
        this.iteratable = iteratable;
    }

    @Override
    public boolean hasNext() {
        return indexInIteratable < iteratable.size();
    }

    @Override
    public void next() {
        indexInIteratable++;
    }

    @Override
    public Object current() {
        return iteratable.get(indexInIteratable);
    }
}
