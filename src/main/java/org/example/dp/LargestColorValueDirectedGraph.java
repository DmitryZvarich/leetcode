package org.example.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestColorValueDirectedGraph {
    private Map<Integer, Set<Integer>> graph;

    private Set<Integer> visited;
    private String colors;

    public int largestPathValue(String colors, int[][] edges) {
        graph = new HashMap<>();
        visited = new HashSet<>();
        this.colors = colors;

        for (int[] edge : edges) {
            graph.computeIfAbsent(edge[0], k -> new HashSet<>()).add(edge[1]);
        }

        int max = -1;

        for (int edge : graph.keySet()){
            max = Math.max(max, dfs(edge, new int[26]));
        }

        return max;
    }

    private int dfs(int node, int[] colorsCnt) {
        if (visited.contains(node)) {
            return -1;
        }

        visited.add(node);

        colorsCnt[colors.charAt(node) - 'a']++;

        int max = 0;
        for (int i : colorsCnt) {
            max = Math.max(max, i);
        }

        Set<Integer> children = graph.get(node);

        if (children == null) {
            return max;
        }

        for (int child : children) {
            int dfs = dfs(child, colorsCnt);
            if (dfs == -1){
                return dfs;
            }
            max = Math.max(max, dfs);
        }

        return max;
    }

}
