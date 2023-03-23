package org.example;

import java.util.*;

public class NumberOperationsMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {
        if (n - 1 > connections.length) {
            return -1;
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] connection : connections) {
            map.computeIfAbsent(connection[0], k -> new HashSet<>()).add(connection[1]);
            map.computeIfAbsent(connection[1], k -> new HashSet<>()).add(connection[0]);
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);


        int isolated = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]){
                continue;
            }

            isolated++;
            dfs(i, map, visited);
        }

        return isolated - 1;
    }

    private void dfs(int node, Map<Integer, Set<Integer>> adj, boolean[] visited) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int neighbor : adj.getOrDefault(node, Collections.emptySet())) {
            dfs(neighbor, adj, visited);
        }
    }
}
