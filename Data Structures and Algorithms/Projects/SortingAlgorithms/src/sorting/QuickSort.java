package sorting;

import java.util.Arrays;

public class QuickSort {

    public void quickSorting(int[] inputArray) {
        quickSorting(inputArray, 0, inputArray.length - 1, -1);
    }

    private void quickSorting(int[] inputArray, int leftIndex, int rightIndex, int boundaryIndex) {
        if (leftIndex >= rightIndex) {
            return;
        }

        var pivotValue = inputArray[rightIndex];
        for (int i = leftIndex; i <= rightIndex; i++) {
            var currentNumberValue = inputArray[i];
            if (currentNumberValue <= pivotValue) {
                boundaryIndex++;
                inputArray[i] = inputArray[boundaryIndex];
                inputArray[boundaryIndex] = currentNumberValue;
            }
        }

        quickSorting(inputArray, leftIndex, boundaryIndex - 1, leftIndex - 1);
        quickSorting(inputArray, boundaryIndex + 1, rightIndex, boundaryIndex);
    }
}
