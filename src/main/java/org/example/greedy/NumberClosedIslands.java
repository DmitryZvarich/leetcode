package org.example.greedy;

import java.util.HashSet;
import java.util.Set;

public class NumberClosedIslands {
    private final Set<int[]> directions = Set.of(new int[]{0, 1}, new int[]{0, -1}, new int[]{1, 0}, new int[]{-1, 0});

    public int closedIsland(int[][] grid) {
        int cnt = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 || visited[i][j]){
                    continue;
                }
                if (dfs(i, j, grid, visited)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean dfs(int r, int c, int[][] grid, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }
        if (grid[r][c] == 1) {
            return true;
        }
        if (visited[r][c]){
            return true;
        }

        visited[r][c] = true;

        boolean f = true;

        for (int[] direction : directions) {
            f &= dfs(r + direction[0], c + direction[1], grid, visited);
        }

        return f;
    }
}
