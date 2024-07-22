package com.binary.tree;

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


    }
