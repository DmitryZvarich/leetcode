package org.example;

import org.example.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class MostPoints {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int[] question = questions[i];

            dp[i] = Math.max(question[0] + dp[Math.min(question[1] + i + 1, n)], dp[i + 1]);
        }

        return dp[0];
    }
}
