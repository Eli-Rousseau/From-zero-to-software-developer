package com.avl.trees;

import javax.xml.transform.Source;

public class AVLTree {

    private class AVLNode {

        private int value;
        private int height;
        private AVLNode leftChildNode;
        private AVLNode rightChildNode;

        public AVLNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode root, int value) {
        if (root == null) {
            return new AVLNode(value);
        }

        if (value < root.value) {
            root.leftChildNode = insert(root.leftChildNode, value);
        }
        else if (value > root.value) {
            root.rightChildNode = insert(root.rightChildNode, value);
        }
        root.height = Math.max(height(root.leftChildNode), height(root.rightChildNode)) + 1;

        balance(root);

        return root;
    }

    private void balance(AVLNode root) {
        if (isLeftSkewed(root)) {
            if (balanceFactor(root.leftChildNode) < 0) {
                System.out.println("Left rotation on" + root.leftChildNode);
            }
            System.out.println("Right rotation on" + root);
        }
        else if (isRightSkewed(root)) {
            if (balanceFactor(root.rightChildNode) > 0) {
                System.out.println("Right rotation on" + root.rightChildNode);
            }
            System.out.println("Left rotation on" + root);
        }
    }

    private AVLNode leftRotate(AVLNode root) {

    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private boolean isLeftSkewed(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightSkewed(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private int balanceFactor(AVLNode node) {
        return (node != null) ? height(node.leftChildNode) - height(node.rightChildNode) : 0;
    }
}
