package searching;

public class JumpSearch {

    public int jumpSearching(int[] inputArray, int queryNumber) {
        var blockSize = (int) Math.sqrt(inputArray.length);
        for (int i = blockSize - 1; i < inputArray.length - 1 + blockSize; i += blockSize) {
            if (i >= inputArray.length) {
                i = inputArray.length - 1;
            }

            if (inputArray[i] > queryNumber) {
                for (int j = i - blockSize + 1; j <= i; j++) {
                    if (inputArray[j] == queryNumber) {
                        return j;
                    }
                }
            }
        }

        return -1;

    }

    public int linearSearching(int[] inputArray, int queryNumber) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == queryNumber) {
                return i;
            }
        }

        return -1;
    }
}
