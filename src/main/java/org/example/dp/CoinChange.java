package org.example.dp;

public class CoinChange {
    private Integer[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new Integer[amount + 1];
        return dfs(coins, amount);
    }

    private int dfs(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != null) {
            return memo[amount];
        }

        int m = Integer.MAX_VALUE;

        for (int coin : coins) {
            int d = dfs(coins, amount - coin);
            if (d == -1) {
                continue;
            }

            m = Math.min(m, d + 1);
        }

        memo[amount] = m == Integer.MAX_VALUE ? -1 : m;
        return memo[amount];
    }
}
