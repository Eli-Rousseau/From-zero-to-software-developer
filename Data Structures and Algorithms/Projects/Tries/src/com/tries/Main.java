package com.tries;

public class Main {
    public static void main(String[] args) {
        var trie = new Trie();
        trie.insert("can");
        trie.insert("canada");
        trie.insert("cataletic");
        trie.insert("canoe");
        trie.insert("cashew");
        trie.insert("bear");
        System.out.println(trie.autoCompletion("cargo"));
    }
}
