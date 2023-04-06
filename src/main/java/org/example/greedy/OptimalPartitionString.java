package org.example.greedy;

import java.util.Arrays;

public class OptimalPartitionString {
    public int partitionString(String s) {
        int res = 0;

        if (s == null || s.isEmpty()) {
            return res;
        }

        int[] charCnt = new int[26];

        for (char c : s.toCharArray()) {
            if (charCnt[c - 'a'] == 1) {
                res++;
                Arrays.fill(charCnt, 0);
            }

            charCnt[c - 'a']++;
        }

        return res + 1;
    }
}
