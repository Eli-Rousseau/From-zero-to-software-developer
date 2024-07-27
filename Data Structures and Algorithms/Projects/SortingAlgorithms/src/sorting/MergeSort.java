package sorting;

import java.util.Arrays;

public class MergeSort {

    public int[] mergeSorting(int[] inputArray) {
        if (inputArray.length > 1) {
            var halfLength = inputArray.length / 2;
            var firstArrayHalf = Arrays.copyOfRange(inputArray, 0, halfLength);
            var secondArrayHalf = Arrays.copyOfRange(inputArray, halfLength, inputArray.length);

            firstArrayHalf = mergeSorting(firstArrayHalf);
            secondArrayHalf = mergeSorting(secondArrayHalf);

            var firstArrayCounter = 0;
            var secondArrayCounter = 0;
            for (int i = 0; i < inputArray.length; i++) {
                if (firstArrayCounter < firstArrayHalf.length && secondArrayCounter < secondArrayHalf.length) {
                    inputArray[i] = (firstArrayHalf[firstArrayCounter] < secondArrayHalf[secondArrayCounter]) ? firstArrayHalf[firstArrayCounter++] : secondArrayHalf[secondArrayCounter++];
                }
                else if (firstArrayCounter == firstArrayHalf.length) {
                    inputArray[i] = secondArrayHalf[secondArrayCounter++];
                }
                else {
                    inputArray[i] = firstArrayHalf[firstArrayCounter++];
                }
            }
        }

        return inputArray;
    }
}
