package com.linked;

public class Main {

    public static void main(String[] args){
        var list = new Linkedlist();
        list.addFirst(20);
        list.addLast(5);
        list.addLast(10);
        list.addLast(4);
        System.out.println(list.indexOf(9));
    }
}
