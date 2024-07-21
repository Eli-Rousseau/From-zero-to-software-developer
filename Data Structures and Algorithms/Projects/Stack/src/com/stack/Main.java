package com.stack;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        var stack = new Stack();
        stack.push(5);
        stack.push(9);
        stack.pop();
        stack.push(16);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
