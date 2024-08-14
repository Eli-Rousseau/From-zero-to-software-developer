package com.avl.trees;

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

        setHeight(root);

        return balance(root);
    }

    private AVLNode balance(AVLNode root) {
        if (isLeftSkewed(root)) {
            if (balanceFactor(root.leftChildNode) < 0) {
                root.leftChildNode = rotateLeft(root.leftChildNode);
            }
            return rotateRight(root);
        }
        else if (isRightSkewed(root)) {
            if (balanceFactor(root.rightChildNode) > 0) {
                root.rightChildNode = rotateRight(root.rightChildNode);
            }
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateLeft(AVLNode root) {
        var newRoot = root.rightChildNode;;
        root.rightChildNode = newRoot.leftChildNode;
        newRoot.leftChildNode = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private AVLNode rotateRight(AVLNode root) {
        var newRoot = root.leftChildNode;
        root.leftChildNode = newRoot.rightChildNode;
        newRoot.rightChildNode = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.leftChildNode), height(node.rightChildNode)) + 1;
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
