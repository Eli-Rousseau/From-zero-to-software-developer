package sorting;

public class InsertionSort {

    public void insertionSorting(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            var selectedNumber = inputArray[i];
            var lastReplacedIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                var currentNumber = inputArray[j];
                if (currentNumber > selectedNumber) {
                    inputArray[j + 1] = currentNumber;
                    lastReplacedIndex = j;
                }
            }
            inputArray[lastReplacedIndex] = selectedNumber;
        }
    }
}
