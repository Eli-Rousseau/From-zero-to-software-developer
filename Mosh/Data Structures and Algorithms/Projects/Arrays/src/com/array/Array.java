package com.array;

import java.util.Arrays;

// Initialize class to manipulate arrays
public class Array {

    // Initialize the class fields
    private int[] arrayInstance;
    private int occupiedArrayIndex = 0;

    // Initialize the class constructor method
    public Array(int length) {
        arrayInstance = new int[length];
    }

    // Initialize method to insert item in the instanceArray
    public void insert(int numberToInsert) {

        // Verifies whether the array should be extended for insertion
        if (occupiedArrayIndex < arrayInstance.length) {

            // Insert numberToInsert into arrayInstance
            arrayInstance[occupiedArrayIndex] = numberToInsert;
        }
        else {

            // Create dummy arrayInstance to populate the extended array
            int[] arrayInstanceDummy = new int[occupiedArrayIndex + 1];

            // Populate the arrayInstanceDummy with the previous arrayInstance
            for (int index = 0; index < occupiedArrayIndex; index++) {
                arrayInstanceDummy[index] = arrayInstance[index];
            }

            // Populate the arrayInstanceDummy with the numberToInsert
            arrayInstanceDummy[occupiedArrayIndex] = numberToInsert;

            // Assign the arrayInstanceDummy as the new arrayInstance
            arrayInstance = arrayInstanceDummy;
        }

        // Increase the occupiedArrayIndex with one
        occupiedArrayIndex++;
    }

    // Initialize method to remove item from arrayInstance at particular index
    public void removeAt(int indexToRemoveNumber) {

        // Create dummy arrayInstance to remove the index number
        int[] arrayInstanceDummy = new int[occupiedArrayIndex - 1];

        // Iterate over the arrayInstance items
        for (int index = 0; index < arrayInstance.length; index++) {

            // Verifies whether the index number has to be removed
            if (index < indexToRemoveNumber) {

                // Populate the arrayInstanceDummy with the items from the arrayInstance
                arrayInstanceDummy[index] = arrayInstance[index];
            }
            else if (index > indexToRemoveNumber){

                // Populate the arrayInstanceDummy with the items from the arrayInstance
                arrayInstanceDummy[index - 1] = arrayInstance[index];
            }
        }

        // Assign the arrayInstanceDummy as the new arrayInstance
        arrayInstance = arrayInstanceDummy;

        // Decrease the occupiedArrayIndex with one
        occupiedArrayIndex--;
    }

    // Initialize method that retrieves index for the occurrence of an item
    public int indexOf(int searchItem) {

        // Initialize the foundIndex variable
        int foundIndex = -1;

        // Iterate over the items of the instanceArray
        for (int index = 0; index < arrayInstance.length; index++) {

            // Verifies whether index number is equals to the searchItem
            if (arrayInstance[index] == searchItem) {
                foundIndex = index;
            }
        }

        // Returns the value of the foundIndex variable
        return foundIndex;
    }

    // Initialize method to print the content of the arrayInstance
    public void print() {
        System.out.println(Arrays.toString(arrayInstance));
    }
}
