package com.array;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        var myArray = new Array(3);
        myArray.print();
        myArray.insert(20);
        myArray.insert(50);
        myArray.insert(100);
        myArray.insert(200);
        myArray.insert(10);
        myArray.print();
        myArray.removeAt(0);
        myArray.print();
        System.out.println(myArray.indexOf(10));
        System.out.println(myArray.indexOf(20));
        var arrayList = new ArrayList();
    }
}
