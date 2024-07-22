package com.hash.tables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        var hashTable = new HashTable(5);
        hashTable.put(24, "Eli");
        System.out.println(hashTable.get(25));
    }

}
