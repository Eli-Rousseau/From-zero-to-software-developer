package com.stack;

// initialize stack class
public class Stack {

    // Initialize the stack fields
    private int[] stackInstance;
    private int size = 0;

    // Initialize a push method
    public void push(int inputItem) {

        // Initialize dummyStackInstance variable
        var dummyStackInstance = new int[++size];

        // Populate the dummyStackInstance with the stackInstance
        for (int i = 0; i < size - 1; i++) {
            dummyStackInstance[i] = stackInstance[i];
        }

        // Add the new inputItem to the dummyStackInstance
        dummyStackInstance[size - 1] = inputItem;

        // Change the stackInstance to the new dummyStackInstance
        stackInstance = dummyStackInstance;
    }

    // Initialize the pop method
    public int pop() {

        // Store last item of the stackInstance
        var lastStackValue = stackInstance[size - 1];

        // Initialize dummyStackInstance variable
        var dummyStackInstance = new int[--size];

        // Populate the dummyStackInstance with the stackInstance
        for (int i = 0; i < size; i++) {
            dummyStackInstance[i] = stackInstance[i];
        }

        // Change the stackInstance to the new dummyStackInstance
        stackInstance = dummyStackInstance;

        // Return the lastStackValue
        return lastStackValue;
    }

    // Initialize peek method
    public int peek() {

        // Returns the last item from the stack
        return stackInstance[size - 1];
    }

    // Initialize isEmpty method
    public boolean isEmpty() {

        // Verifies whether the stack is empty
        return !(size > 0);
    }
}
