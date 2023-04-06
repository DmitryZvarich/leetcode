package org.example.dfs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class NumberDistinctIslands {
    private final Set<Object[]> directions = Set.of(new Object[]{0, 1, 'R'}, new Object[]{0, -1, 'L'}, new Object[]{1, 0, 'D'}, new Object[]{-1, 0, 'U'});
    private int[][] grid;
    private boolean[][] visit;

    public int numDistinctIslands(int[][] grid) {
        visit = new boolean[grid.length][grid[0].length];
        this.grid = grid;
        Set<String> islands = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 || visit[i][j]) {
                    continue;
                }

                StringBuilder island = new StringBuilder();

                dfs(i, j, '0', island);

                islands.add(island.toString());
            }
        }

        return islands.size();
    }

    private void dfs(int r, int c, char dir, StringBuilder island) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return;
        }

        if (visit[r][c]) {
            return;
        }

        visit[r][c] = true;

        if (grid[r][c] == 0) {
            return;
        }

        island.append(dir);

        for (Object[] direction : directions) {
            dfs(r + (int) direction[0], c + (int) direction[1], (char) direction[2], island);
        }

        island.append('0');
    }
}
