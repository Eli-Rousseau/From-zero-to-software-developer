package searching;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public int binarySearchingRecursive(int[] inputArray, int queryNumber) {
        Arrays.sort(inputArray);
        return binarySearchingRecursive(inputArray, queryNumber, 0, inputArray.length - 1);
    }

    public int binarySearchingRecursive(int[] inputArray, int queryNumber, int leftBoundary, int rightBoundary) {
        if (leftBoundary > rightBoundary) {
            return -1;
        }

        var middleIndex = (leftBoundary + rightBoundary) / 2;
        if (inputArray[middleIndex] == queryNumber) {
            return middleIndex;
        } else if (inputArray[middleIndex] > queryNumber) {
            return binarySearchingRecursive(inputArray, queryNumber, leftBoundary, middleIndex - 1);
        } else {
            return binarySearchingRecursive(inputArray, queryNumber, middleIndex + 1, rightBoundary);
        }
    }
}
