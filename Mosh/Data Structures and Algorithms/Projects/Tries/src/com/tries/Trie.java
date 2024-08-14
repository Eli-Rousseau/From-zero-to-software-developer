package com.tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    public static int ALPHABET_SIZE = 26;

    private class Node  {

        private Character value;
        private Map<Character, Node> childeren = new HashMap<>();
        private boolean isEndOfWord;

        private Node(Character value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }

        private boolean hasChild(Character ch) {
            return childeren.containsKey(ch);
        }

        private void addChild(Character ch) {
            childeren.put(ch, new Node(ch));
        }

        private Node getChild(Character ch) {
            return childeren.get(ch);
        }

        private Node[] getChilderen() {
            return childeren.values().toArray(new Node[0]);
        }

        private boolean hasChilderen() {
            return !childeren.isEmpty();
        }

        private void removeChild(Character ch) {
            childeren.remove(ch);
        }
    }

    private Node trie;

    public Trie() {
        trie = new Node(' ');
    }

    public void insert(String word) {
        var currentNode = trie;
        for (Character ch: word.toCharArray()) {
            if (!currentNode.hasChild(ch)) {
                currentNode.addChild(ch);
            }
            currentNode = currentNode.getChild(ch);
        }
        currentNode.isEndOfWord = true;
    }

    public boolean contains(String word) {
        if (!trie.hasChilderen()) {
            throw new IllegalStateException();
        }

        if (word == null) {
            return false;
        }

        var currentNode = trie;
        for (Character ch: word.toCharArray()) {
            if (!currentNode.hasChild(ch)) {
                return false;
            }
            currentNode = currentNode.getChild(ch);
        }
        return currentNode.isEndOfWord;
    }

    public void traverse() {
        traverse(trie);
    }

    private void traverse(Node root) {
        System.out.println(root.value);

        for (Node childNode : root.getChilderen()) {
            traverse(childNode);
        }
    }

    public void remove(String word) {
        if (!contains(word)) {
            throw new IllegalStateException();
        }
        remove(trie, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.isEndOfWord = false;
            return;
        }

        var ch = word.charAt(index);
        var childNode = root.getChild(ch);
        remove(childNode, word, ++index);

        if (!childNode.hasChilderen() && !childNode.isEndOfWord) {
            root.removeChild(ch);
        }
    }

    public ArrayList<String> autoCompletion(String word) {
        var collection = new ArrayList<String>();

        var currentNode = trie;
        for (Character ch : word.toCharArray()) {
            if (!currentNode.hasChild(ch)) {
                return collection;
            }
            currentNode = currentNode.getChild(ch);
        }

        autoCompletion(currentNode, word, collection);
        return collection;
    }

    public void autoCompletion(Node root, String word, ArrayList<String> collection) {
        if (root.isEndOfWord) {
            collection.addLast(word);
        }

        for (Node nodeChild : root.getChilderen()) {
            autoCompletion(nodeChild, word + nodeChild.value, collection);
        }
    }
}
