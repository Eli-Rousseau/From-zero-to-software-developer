package com.stack;

import java.util.Stack;

// Initialize class to help reverse order of String object
public class StringReverser {

    // Initialize class constructor method
    public StringBuffer reverse(String inputString) {

        // Verifies whether the inputString is null
        if (inputString == null) {
            throw new IllegalArgumentException();
        }

        // Initialize a stack object
        Stack<Character> stack = new Stack<>();

        // Iterate over each character in the string
        for (char ch: inputString.toCharArray()) {

            // Push each character of the string into the stack
            stack.push(ch);
        }

        // Initialize the reverseString variable
        StringBuffer reverseString = new StringBuffer();

        // Iterate over each character in the string
        while (!(stack.isEmpty())) {

            // Add the top stack character to the reverseString
            reverseString.append(stack.pop());
        }

        // Return the reverseString
        return reverseString;
    }
}
