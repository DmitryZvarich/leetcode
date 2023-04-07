package org.example.dfs;

public class NumberEnclaves {
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            dfs(i, 0, grid);
            dfs(i, grid[0].length - 1, grid);
        }

        for (int i = 0; i < grid[0].length; i++) {
            dfs(0, i, grid);
            dfs(grid.length - 1, i, grid);
        }

        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, int[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return;
        }

        grid[r][c] = 0;

        for (int[] direction : directions) {
            dfs(r + direction[0], c + direction[1], grid);
        }
    }
}
