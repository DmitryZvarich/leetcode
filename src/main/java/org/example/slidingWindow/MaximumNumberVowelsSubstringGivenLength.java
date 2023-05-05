package org.example.slidingWindow;

import java.util.Set;

public class MaximumNumberVowelsSubstringGivenLength {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        int cur = 0;

        while (right < s.length()) {
            if (right - left == k) {
                char c = s.charAt(left++);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    cur--;
                }
            }

            char c = s.charAt(right++);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cur++;
            }

            res = Math.max(res, cur);
        }

        return res;
    }
}
