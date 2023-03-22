package org.example;

import java.util.HashSet;
import java.util.Set;

public class Trie {
    private Set<String> cache;
    public Trie() {
        cache = new HashSet<>();
    }

    public void insert(String word) {
        cache.add(word);
    }

    public boolean search(String word) {
        return cache.contains(word);
    }

    public boolean startsWith(String prefix) {
        return cache.stream().anyMatch(s -> s.startsWith(prefix));
    }
}
