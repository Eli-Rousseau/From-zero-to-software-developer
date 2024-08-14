package sorting;

public class SelectionSort {

    public void selectionSort(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            var smallestValueIndex = i;
            for (int j = i + 1; j < inputArray.length; j++) {
                var currentValueIndex = j;
                if (inputArray[currentValueIndex] < inputArray[smallestValueIndex]) {
                    smallestValueIndex = currentValueIndex;
                }
            }
            var currentFirstValue = inputArray[i];
            var smallestValue = inputArray[smallestValueIndex];
            inputArray[i] = smallestValue;
            inputArray[smallestValueIndex] = currentFirstValue;
        }
    }
}
