package org.example.design.trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }

        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;

        for (char c : word.toCharArray()) {
            node = node.get(c);
            if (node == null) {
                return null;
            }
        }

        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
