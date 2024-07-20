package com.linked;

public class Linkedlist {

    private class Node {

        // Initialize the class fields
        private int value;
        private Node next;

        // Initialize the class constructor method
        public Node(int value) {
            this.value = value;
        }
    }

    // Initialize the class fields
    private Node first;
    private Node last;

    // Initialize method to add the item at last position of the LinkedList
    public void addLast(int lastPoint){

        // Initialize the value of the Node object
        var node = new Node(lastPoint);

        // Verifies whether the first node has already been defined
        if (this.isEmpty()) {
            first = node;
        }
        else {
            last.next = node;
        }

        // Change the last node value
        last = node;
    }

    // Initialize method to add the item at first position of the LinkedList
    public void addFirst(int firstPoint) {

        // Initialize the value of the Node object
        var node = new Node(firstPoint);

        // Verifies whether the LinkedList is empty
        if (this.isEmpty()) {
            last = node;
        }
        else {
            node.next = first;
        }

        // Change the first node value
        first = node;
    }

    // Initialize method to remove the first item from LinkedList
    public void removeFirst() {

        // Verifies whether the LinkedList is empty
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Can not remove item from empty LinkedList instance.");
        }

        // Initialize second variable to reference to the second item from LinkedList
        Node second = first.next;

        // Verifies whether the LinkedList contains a single item
        if (first == second) {

            // Initialize the first and last fields as null objects
            first = null;
            last = null;
        }
        else {
            // Remove link from the first node
            first.next = null;

            // Initialize the second node as the first node
            first = second;
        }
    }

    // Initialize method to remove the last item from LinkedList
    public void removeLast() {

        // Verifies whether the LinkedList is empty
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Can not remove item from empty LinkedList instance.");
        }

        // Initialize variable representing the current node
        Node currentNode = first;

        // Iterate over the LinkedList till reaching the for last item
        while (!(currentNode.next.next == null)) {

            // Set the next node as the currentNode
            currentNode = currentNode.next;
        }

        // Verifies whether the LinkedList contains a single item
        if (currentNode == last) {

            // Initialize the first and last fields as null objects
            first = null;
            last = null;
        }
        else {

            // Initialize the for last node as the last node
            last = currentNode;
            last.next = null;
        }
    }

    // Initialize method to find first occurrence of search item in LinkedList
    public int indexOf(int itemToSearch) {

        // Verifies whether the LinkedList is empty
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Can not find item within empty LinkedList instance.");
        }

        // Initialize variable representing the current node
        Node currentNode = first;

        // Initialize dummy variable to track the node index
        int index = 0;

        // Iterate over all the nodes of the LinkedList
        while (!(currentNode == null)) {

            // Verifies whether the currentNode equals the itemToSearch
            if (currentNode.value == itemToSearch) {
                return index;
            }

            // Change the index value by increasing with one
            index++;

            // Set the next node as the currentNode
            currentNode = currentNode.next;
        }

        // Return -1 when the itemToSearch does not occur in the LinkedList
        return -1;
    }

    // Initialize method to verify the presence of an item inside LinkedList
    public boolean contains(int itemToSearch) {

        return this.indexOf(itemToSearch) != -1;
    }

    // Initialize method that returns that size of the LinkedList
    public int size() {

        // Verifies whether LinkedList is empty
        if (this.isEmpty()) {
            return 0;
        }

        // Initialize variable representing the current node
        Node currentNode = first;

        // Initialize the size variable
        int size = 1;

        // Iterate over all the nodes of the LinkedList
        while (!(currentNode.next == null)) {

            // Increase the size variable with one
            size++;

            // Set the next node as the currentNode
            currentNode = currentNode.next;
        }

        // Returns the size of the LinkedList
        return size;
    }

    // Initialize method to print node values from LinkedList
    public void print() {

        // Verifies whether the LinkedList is not empty
        if (!(this.isEmpty())) {

            // Initialize variable representing the current node
            Node currentNode = first;

            // Iterate over all the nodes of the LinkedList
            while (!(currentNode == null)) {

                // Print the value of the currentNode to the console
                System.out.println(currentNode.value);

                // Set the next node as the currentNode
                currentNode = currentNode.next;
            }
        }
    }

    // Initialize method that verifies is LinkedList is empty
    private boolean isEmpty() {

        // Verifies whether LinkedList is empty
        return first == null;
    }
}
