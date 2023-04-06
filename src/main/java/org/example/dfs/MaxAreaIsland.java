package org.example.dfs;

public class MaxAreaIsland {
    private int[][] grid;
    private boolean[][] visit;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        visit = new boolean[grid.length][grid[0].length];
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(i, j));
            }
        }


        return res;
    }

    private int dfs(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return 0;
        }

        if (visit[r][c]) {
            return 0;
        }

        visit[r][c] = true;

        if (grid[r][c] == 0) {
            return 0;
        }

        int res = 1;

        res += dfs(r + 1, c);
        res += dfs(r - 1, c);
        res += dfs(r, c + 1);
        res += dfs(r, c - 1);

        return res;
    }
}
