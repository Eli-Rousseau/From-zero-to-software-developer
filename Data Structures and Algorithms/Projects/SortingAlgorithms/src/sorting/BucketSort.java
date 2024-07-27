package sorting;

import java.util.LinkedList;

public class BucketSort {

    public void bucketSorting(int[] inputArray, int numberOfBuckets) {
        LinkedList<Integer>[] buckets = new LinkedList[numberOfBuckets];
        for (int i = 0; i < numberOfBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }

        for (int currentNumber : inputArray) {
            var currentNumberQuotient = currentNumber / numberOfBuckets;
            buckets[currentNumberQuotient].add(currentNumber);
        }

        var bucketsIndex = 0;
        for (LinkedList<Integer> bucket : buckets) {
            bubbleSorting(bucket);
            for (int currentNumber : bucket) {
                inputArray[bucketsIndex++] = currentNumber;
            }
        }
    }

    public void bubbleSorting(LinkedList<Integer> inputArray) {
        boolean isSorted;
        for (int i = 0; i < inputArray.size(); i++) {
            isSorted = true;
            for (int j = 1; j < inputArray.size() - i; j++) {
                var currentIndexNumber = inputArray.get(j);
                var previousIndexNumber = inputArray.get(j);
                if (currentIndexNumber < previousIndexNumber) {
                    inputArray.add(j, previousIndexNumber);
                    inputArray.add(j - 1, currentIndexNumber);
                    isSorted = false;
                }
            }
            if (isSorted) {
                return;
            }
        }
    }
}
