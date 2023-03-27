package org.example.dfs;

import java.util.*;

public class CountUnreachablePairsNodesUndirectedGraph {
    public long countPairs(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int cnt = n;

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        long res = 0;

        for (int i = 0; i < n; i++) {
            int cur = dfs(i, adj, visited);

            res += (long) cur * (cnt - cur);

            cnt -= cur;
        }

        return res;
    }

    private int dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited) {
        if (visited[node]) {
            return 0;
        }
        visited[node] = true;

        int res = 1;

        for (Integer next : adj.getOrDefault(node, Collections.emptyList())) {
            res += dfs(next, adj, visited);
        }

        return res;
    }
}
