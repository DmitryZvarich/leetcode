package org.example.twoPointers;

public class StringCompression443 {
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;

        while (right < chars.length) {
            char ch = chars[right++];
            int cnt = 1;

            while (right < chars.length && chars[right] == ch) {
                cnt++;
                right++;
            }

            chars[left++] = ch;

            if (cnt == 1) {
                continue;
            }

            for (char c : String.valueOf(cnt).toCharArray()) {
                chars[left++] = c;
            }
        }

        return left;
    }
}
