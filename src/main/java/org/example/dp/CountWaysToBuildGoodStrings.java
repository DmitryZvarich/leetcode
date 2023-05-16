package org.example.dp;

public class CountWaysToBuildGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        int mod = 1_000_000_007;

        for (int i = 1; i < dp.length; i++) {
            if (i >= zero) {
                dp[i] += dp[i - zero];
            }

            if (i >= one) {
                dp[i] += dp[i - one];
            }

            dp[i] %= mod;
        }

        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum += dp[i];
            sum %= mod;
        }

        return sum;
    }
}
