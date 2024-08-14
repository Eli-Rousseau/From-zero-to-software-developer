package com.binary.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryTree {

    private class Node {

        private int value;

        private Node leftChildNode;
        private Node rightChildNode;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int insertValue) {
        var newNode = new Node(insertValue);

        if (root == null) {
            root = newNode;
            return;
        }

        var currentNode = root;
        while (currentNode != null) {
            if (insertValue > currentNode.value) {
                if (currentNode.rightChildNode == null) {
                    currentNode.rightChildNode = newNode;
                }
                currentNode = currentNode.rightChildNode;
            }
            else if (insertValue < currentNode.value) {
                if (currentNode.leftChildNode == null) {
                    currentNode.leftChildNode = newNode;
                }
                currentNode = currentNode.leftChildNode;
            } else {
                return;
            }
            }
        }

        public boolean find(int searchValue) {

        if (root == null) {
            throw new IllegalArgumentException();
        }

        var currentNode = root;
        while (currentNode != null) {
            if (currentNode.value > searchValue) {
                currentNode = currentNode.leftChildNode;
            }
            else if (currentNode.value < searchValue){
                currentNode = currentNode.rightChildNode;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        traversePreOrder(root.leftChildNode);
        traversePreOrder(root.rightChildNode);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.leftChildNode);
        System.out.println(root);
        traverseInOrder(root.rightChildNode);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.leftChildNode);
        traversePostOrder(root.rightChildNode);
        System.out.println(root);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }

        if (isLeaf(root)) {
            return 0;
        }
        return 1 + Math.max(height(root.leftChildNode), height(root.rightChildNode));
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
        if (isLeaf(root)) {
            return root.value;
        }

        var left = min(root.leftChildNode);
        var right = min(root.rightChildNode);

        return Math.min(Math.min(left, right), root.value);
    }

    private boolean isLeaf (Node root) {
        return root.leftChildNode == null && root.rightChildNode == null;
    }

    public boolean equals(BinaryTree secondTree) {
        return equals(root, secondTree.root);
    }

    private boolean equals(Node firstTreeNode, Node secondTreeNode) {
        if (firstTreeNode == null && secondTreeNode == null) {
            return true;
        }

        if (firstTreeNode != null && secondTreeNode != null)
            return firstTreeNode.value == secondTreeNode.value &&
                    equals(firstTreeNode.leftChildNode, secondTreeNode.leftChildNode) &&
                    equals(firstTreeNode.rightChildNode, secondTreeNode.rightChildNode);

        return false;
    }

    public boolean valid() {
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean valid(Node root, int minRange, int maxRange) {
        if (root == null) {
            return true;
        }

        if (root != null) {
            return root.value > minRange && root.value < maxRange &&
                    valid(root.leftChildNode, minRange, root.value) &&
                    valid(root.rightChildNode, root.value, maxRange);
        }
        return false;
    }

    public void swapRoot() {
        var temp = root.leftChildNode;
        root.leftChildNode = root.rightChildNode;
        root.rightChildNode = temp;
    }

    public ArrayList<Integer> findNodesAtDistanceK(int k) {
        ArrayList<Integer> nodesToPrint = new ArrayList<>();
        return findNodesAtDistanceK(root, k, 0, nodesToPrint);
    }

    private ArrayList<Integer> findNodesAtDistanceK(Node root, int k, int distance, ArrayList<Integer> nodesToPrint) {
        if (root == null) {
            return nodesToPrint;
        }

        if (k == distance) {
            nodesToPrint.add(root.value);
        }
        findNodesAtDistanceK(root.leftChildNode, k, distance + 1, nodesToPrint);
        findNodesAtDistanceK(root.rightChildNode, k, distance + 1, nodesToPrint);
        return nodesToPrint;
    }

}
