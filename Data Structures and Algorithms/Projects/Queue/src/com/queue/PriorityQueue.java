package com.queue;

import java.util.Arrays;

public class PriorityQueue {

    // Initialize a sortedArray field
    private int[] priorityArray;

    // Initialize the item counts
    int count = 0;

    // Initialize a constructor method
    public PriorityQueue(int capacity) {
        priorityArray = new int[capacity];
    }

    // Initialize add method
    public void add(int item) {
        if (count == priorityArray.length) {
            throw new IllegalStateException();
        }

        int i;
        for (i = count - 1; i >= 0; i--) {
            if (priorityArray[i] >= item) {
                priorityArray[i + 1] = priorityArray[i];
            }
            else {
                break;
            }
        }
        priorityArray[i + 1] = item;
        count++;
    }

    // Initialize the remove method
    public int remove() {
        if (count == 0) {
            throw new IllegalArgumentException();
        }
        var removedValue = priorityArray[--count];
        priorityArray[count] = 0;
        return removedValue;
    }

    // Intialize toString method
    @Override
    public String toString() {
        return Arrays.toString(priorityArray);
    }

}
