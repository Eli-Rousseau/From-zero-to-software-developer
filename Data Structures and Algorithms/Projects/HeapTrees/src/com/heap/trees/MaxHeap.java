package com.heap.trees;

import java.util.ArrayList;

public class MaxHeap {

    public static ArrayList<Integer> heapify(ArrayList<Integer> list) {
        var lastParentIndex = list.size() / 2 - 1;
        for (int index = lastParentIndex; index >= 0; index--) {
            heapify(list, index);
        }
        return list;
    }

    public static int findKthLargestItem(ArrayList<Integer> list, int k) {
        var largestValue = 0;
        for (int index = 0; index < k; index++) {
            heapify(list);
            largestValue = list.getFirst();
            list.removeFirst();
        }
        return largestValue;
    }

    private static void heapify(ArrayList<Integer> list, int rootNodeIndex) {
        var largestIndex = rootNodeIndex;

        var leftChildNodeIndex = rootNodeIndex * 2 + 1;
        if (leftChildNodeIndex < list.size() && list.get(leftChildNodeIndex) > list.get(largestIndex)) {
            largestIndex = leftChildNodeIndex;
        }

        var rightChildNodeIndex = rootNodeIndex * 2 + 2;
        if (rightChildNodeIndex < list.size() && list.get(rightChildNodeIndex) > list.get(largestIndex)) {
            largestIndex = rightChildNodeIndex;
        }

        if (rootNodeIndex == largestIndex) {
            return;
        }

        swap(list, rootNodeIndex, largestIndex);
        heapify(list, largestIndex);
    }

    private static void swap(ArrayList<Integer> list, int rootNodeIndex, int childNodeIndex) {
        var rootNodeValue = list.get(rootNodeIndex);
        var childNodeValue = list.get(childNodeIndex);
        list.set(rootNodeIndex, childNodeValue);
        list.set(childNodeIndex, rootNodeValue);
    }
}
