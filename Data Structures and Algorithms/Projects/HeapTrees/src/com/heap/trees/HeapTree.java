package com.heap.trees;

import java.util.ArrayList;

public class HeapTree {

    private ArrayList<Integer> heapTree;

    public HeapTree() {
        heapTree = new ArrayList<>();
    }

    public void insert(int value) {
       heapTree.addLast(value);
       bubbleUP(heapTree.size() - 1);
    }

    private void bubbleUP(int newNodeIndex) {
        if (newNodeIndex == 0) {
            return;
        }

        var newNodeValue = heapTree.get(newNodeIndex);
        int parentNodeIndex = findParentNodeIndex(newNodeIndex);
        var parentNodeValue = heapTree.get(parentNodeIndex);

        if (parentNodeValue < newNodeValue) {
            heapTree.set(newNodeIndex, parentNodeValue);
            heapTree.set(parentNodeIndex, newNodeValue);
            bubbleUP(parentNodeIndex);
        }
    }

    public int remove() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        var removedNode = heapTree.getFirst();
        heapTree.set(0, heapTree.getLast());
        heapTree.removeLast();

        bubbleDown(0);
        return removedNode;
    }

    public boolean isEmpty() {
        return heapTree == null;
    }

    private void bubbleDown(int rootNodeIndex) {
        var leftChildNodeIndex = findLeftChildNodeIndex(rootNodeIndex);
        var rightChildNodeIndex = findRightChildNodeIndex(rootNodeIndex);
        if (isOutsideTree(leftChildNodeIndex, rightChildNodeIndex)) {
            return;
        }

        var rootNodeValue = heapTree.get(rootNodeIndex);
        var leftChildNodeValue = heapTree.get(leftChildNodeIndex);
        var rightChildNodeValue = heapTree.get(rightChildNodeIndex);
        if (isRootNodeSmaller(rootNodeValue, leftChildNodeValue, rightChildNodeValue)) {
            if (findLargestChildNode(leftChildNodeValue, rightChildNodeValue).equals("left")) {
                heapTree.set(rootNodeIndex, leftChildNodeValue);
                heapTree.set(leftChildNodeIndex, rootNodeValue);
                bubbleDown(leftChildNodeIndex);
            }
            else {
                heapTree.set(rootNodeIndex, rightChildNodeValue);
                heapTree.set(rightChildNodeIndex, rootNodeValue);
                bubbleDown(rightChildNodeIndex);
            }
        }
    }

    private int findParentNodeIndex(int index) {
        return (index - 1) / 2;
    }

    private int findLeftChildNodeIndex(int index) {
       return index * 2 + 1;
    }

    private int findRightChildNodeIndex(int index) {
        return index * 2 + 2;
    }

    private boolean isOutsideTree(int leftChildNodeIndex, int rightChildNodeIndex) {
        return leftChildNodeIndex > heapTree.size() - 1 || rightChildNodeIndex > heapTree.size() - 1;
    }

    private boolean isRootNodeSmaller(int rootNodeValue, int leftChildNodeValue, int rightChildNodeValue) {
        return rootNodeValue < leftChildNodeValue || rootNodeValue < rightChildNodeValue;
    }

    private String findLargestChildNode(int leftChildNodeValue, int rightChildNodeValue) {
        return leftChildNodeValue > rightChildNodeValue ? "left" : "right";
    }
}
