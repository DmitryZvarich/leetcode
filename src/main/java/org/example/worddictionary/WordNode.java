package org.example.worddictionary;

public class WordNode {
    private WordNode[] links;
    private final int R = 26;
    private boolean isEnd;

    public WordNode() {
        links = new WordNode[R];
    }

    public WordNode[] getLinks() {
        return links;
    }

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public WordNode get(char c) {
        return links[c - 'a'];
    }

    public void add(char c, WordNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
