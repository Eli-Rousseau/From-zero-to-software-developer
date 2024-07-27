package searching;

public class ExponentialSearch {

    public int exponentialSearching(int[] inputArray, int queryNumber) {
        var windowSize = 1;
        while (windowSize <= inputArray.length) {
            if (inputArray[windowSize - 1] >= queryNumber) {
                break;
            }
            windowSize *= 2;
        }

        if (windowSize > inputArray.length) {
            return -1;
        }

        for (int i = windowSize / 2; i < windowSize; i++) {
            if (inputArray[i] == queryNumber) {
                return i;
            }
        }

        return -1;
    }
}
