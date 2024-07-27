package searching;

public class LinearSearch {

    public int linearSearching(int[] inputArray, int queryNumber) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == queryNumber) {
                return i;
            }
        }

        return -1;
    }
}
