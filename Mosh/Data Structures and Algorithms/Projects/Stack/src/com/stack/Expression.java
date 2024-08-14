package com.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    // Initialize the bracket fields
    private final List<Character> leftBracketChars = Arrays.asList('[', '{', '<', '(');
    private final List<Character> rightBracketChars = Arrays.asList(']', '}', '>', ')');

    // Initialize method to check whether the inputExpression is balanced
    public boolean isBalanced(String inputExpression) {

        // initialize stack object
        Stack<Character> stack = new Stack<>();

        // Iterate over the inputExpression characters
        for (char ch: inputExpression.toCharArray()) {

            // Verifies whether ch is opening bracket
            if (isOpeningChar(ch)) {

                // Push the ch to the stack
                stack.push(ch);
            }

            // Verifies whether ch is closing bracket
            if (isClosingChar(ch)) {

                // Verifies whether the stack is empty
                if (stack.isEmpty()) {
                    return false;
                }

                // Initialize variable representing the top stack item
                var top = stack.pop();

                // Verifies whether the current ch and top ch are from the same type
                if ( isMatchingChar(ch, top) ) {
                    return false;
                }
            }
        }

        // Returns whether the stack is balanced
        return stack.isEmpty();
    }

    // Initialize method to control whether a character is a valid opening bracket symbol
    private boolean isOpeningChar(char ch) {
        return (leftBracketChars.contains(ch));
    }

    // Initialize method to control whether a character is a valid closing bracket symbol
    private boolean isClosingChar(char ch) {
        return (rightBracketChars.contains(ch));
    }

    // Initialize method to control for matching brackets
    private boolean isMatchingChar(char ch, char top) {
        return leftBracketChars.indexOf(ch) == rightBracketChars.indexOf(top);
    }

}
