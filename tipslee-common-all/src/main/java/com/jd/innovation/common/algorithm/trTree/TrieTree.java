package com.jd.innovation.common.algorithm.trTree;

import java.util.HashMap;
import java.util.List;

/**
 * Created by cdyuanlifei on 2016/7/29.
 */
public class TrieTree {
    private Node root;

    public TrieTree() {
        root = new Node(' ');
    }

    /**
     * Batch insert.
     * @param words
     */
    public void insert(List<String> words) {
        if (words == null || words.size() <=0) return;
        int wordsLength = words.size();
        for (int i = 0; i < wordsLength; ++i) {
            insert(words.get(i));
        }
    }

    /**
     * Insert.
     * @param word
     */
    public void insert(String word) {
        if (word == null || search(word) == true) return;

        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            Node child = current.subNode(word.charAt(i));
            if (child != null) {
                current = child;
            } else {
                Node node = new Node(word.charAt(i));
                current.childMap.put(node.content, node);
                current = current.subNode(word.charAt(i));
            }
            current.count++;
        }
        // Set isEnd to indicate end of the word
        current.isEnd = true;
    }

    public boolean search(String word) {
        Node current = root;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            Node node = current.subNode(word.charAt(i));
            if (node == null)
                return false;
            else
                current = node;
        }
        /*
        * This means that a string exists, but make sure its
        * a word by checking its 'isEnd' flag
        */
        if (current.isEnd == true) return true;
        else return false;
    }

    /**
     * Search prefix.
     * e.g. given word = "abcd", if word "abc" exists in trie-tree, the method returns true,
     * otherwise returns false
     * e.g. given word = "abcd", if only one word "abce" exists in trie-tree, the method returns false
     *
     * @param word
     * @return boolean
     */
    public boolean searchPrefix(String word) {
        Node current = root;
        int wordLength = word.length();
        for (int i = 0; i < wordLength; i++) {
            Node node = current.subNode(word.charAt(i));
            if (node == null) {
                if (current.isEnd == true) return true;
                else return false;
            } else
                current = node;
        }
        /*
        * This means that a string exists, but make sure its
        * a word by checking its 'isEnd' flag
        */
        if (current.isEnd == true) return true;
        else return false;
    }

    public void deleteWord(String word) {
        if (word == null || search(word) == false) return;

        Node current = root;
        for (char c : word.toCharArray()) {
            Node child = current.subNode(c);
            if (child.count == 1) {
                current.childMap.remove(child.content);
                return;
            } else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }
}

class Node {
    char content; // the character in the node
    boolean isEnd; // whether the end of the words
    int count;  // the number of words sharing this character
    HashMap<Character, Node> childMap; // the child map

    public Node(char c) {
        childMap = new HashMap<Character, Node>();
        isEnd = false;
        content = c;
        count = 0;
    }

    public Node subNode(char c) {
        if (childMap != null) {
            return childMap.get(c);
        }
        return null;
    }
}