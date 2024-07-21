package com.queue;

import java.util.Arrays;

// Initialize class
public class ArrayQueue {

    // Initialize queue field
    private int[] queue;

    // Initialize front and tail fields
    private int front = 0;
    private int tail = 0;

    // Initialize the class constructor method
    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    // Initialize enqueue method
    public void enqueue(int item) {
        tail = tail % queue.length;
        queue[tail++] = item;
    }

    // Initialize dequeue method
    public int dequeue() {
        queue[front] = 0;
        front = (front % queue.length);
        return queue[front++];
    }

    @Override
    // Initialize print method
    public String toString() {
        return Arrays.toString(queue);
    }

}
