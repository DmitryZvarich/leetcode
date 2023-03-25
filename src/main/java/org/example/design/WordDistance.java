package org.example.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    private final Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;

        for (int i1 : map.get(word1)) {
            for (int i2 : map.get(word2)) {
                res = Math.min(res, Math.abs(i1 - i2));
            }
        }

        return res;
    }
}
