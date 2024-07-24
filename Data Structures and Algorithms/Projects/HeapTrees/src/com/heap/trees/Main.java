package com.heap.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var tree = new HeapTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(17);
        tree.insert(4);
        tree.insert(22);
        System.out.println(tree.remove());

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 3, 8, 4, 1, 2));
        System.out.println(MaxHeap.findKthLargestItem(list, 6));
    }
}
