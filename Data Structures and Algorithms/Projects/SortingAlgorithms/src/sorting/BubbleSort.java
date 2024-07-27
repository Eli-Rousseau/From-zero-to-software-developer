package sorting;

public class BubbleSort {

    public void bubbleSorting(int[] inputArray) {
        boolean isSorted;
        for (int i = 0; i < inputArray.length; i++) {
            isSorted = true;
            for (int j = 1; j < inputArray.length - i; j++) {
                var currentIndexNumber = inputArray[j];
                var previousIndexNumber = inputArray[j - 1];
                if (currentIndexNumber < previousIndexNumber) {
                    inputArray[j] = previousIndexNumber;
                    inputArray[j - 1] = currentIndexNumber;
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }
}
