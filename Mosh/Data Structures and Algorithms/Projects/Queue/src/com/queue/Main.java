package com.queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {
        var priorityQueue = new PriorityQueue(5);
        System.out.println(priorityQueue.toString());
        priorityQueue.add(10);
        priorityQueue.add(6);
        priorityQueue.add(7);
        priorityQueue.add(8);
        priorityQueue.add(9);
        System.out.println(priorityQueue.toString());
        priorityQueue.remove();
        priorityQueue.remove();
        System.out.println(priorityQueue.toString());
    }

}
