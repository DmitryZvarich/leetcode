package org.example.worddictionary;

import java.util.*;

public class WordDictionary {
    private WordNode root;

    public WordDictionary() {
        root = new WordNode();
    }

    public void addWord(String word) {
        WordNode node = root;

        for (char c : word.toCharArray()) {
            if (!node.contains(c)) {
                node.add(c, new WordNode());
            }

            node = node.get(c);
        }

        node.setEnd();
    }

    private boolean dfs(WordNode node, int ind, String word) {
        if (node == null) {
            return false;
        }

        if (ind == word.length() && node.isEnd()){
            return true;
        }

        char c = word.charAt(ind);
        boolean res = false;

        if (c == '.') {
            for (WordNode next : node.getLinks()){
                res = res || dfs(next, ind + 1, word);
            }
        } else
        {
            WordNode next = node.get(c);
            res = dfs(next, ind + 1, word);
        }

        return res;
    }

    public boolean search(String word) {
        return dfs(root, 0, word);
    }
}
