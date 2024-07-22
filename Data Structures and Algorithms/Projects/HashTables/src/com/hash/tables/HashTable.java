package com.hash.tables;

import java.util.LinkedList;
import java.util.Objects;

// Initialize the HashTable class
public class HashTable {

    private class Entry {

        // Initialize the entry fields
        private int key;
        private String value;

        // Initialize the constructor method
        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        // Initialize the getKey method
        public int getKey() {
            return key;
        }

        // Initialize the getValue method
        public String getValue() {
            return value;
        }
    }

    // Initialize the size field
    private int size;

    // Initialize an hashTable field
    private LinkedList<Entry>[] hashTable;

    // Initialize the constructor method
    public HashTable(int size) {
        this.size = size;
        hashTable = new LinkedList[size];
    }

    // Initialize the put method
    public void put(int key, String value) {

        int indexHashTable = hashFunction(key);

        if (hashTable[indexHashTable] == null) {
            hashTable[indexHashTable] = new LinkedList<>();
        }

        var linkedList = hashTable[indexHashTable];
        for (Entry entry: linkedList) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        linkedList.addLast(new Entry(key, value));
    }

    // Initialize the get method
    public String get(int key) {

        int indexHashTable = hashFunction(key);

        var linkedList = hashTable[indexHashTable];

        if (!(linkedList == null)) {
            for (Entry entry: linkedList) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }

        return null;
    }


    // Initialize a hashFunction method
    private int hashFunction(int key) {
        return key % size;
    }


}
