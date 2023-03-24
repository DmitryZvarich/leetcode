package org.example.dfs;

import java.util.*;

public class ReorderRoutesMakeAllPathsLeadCityZero {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<List<Integer>>> adj = new HashMap<>();

        for (int[] connection : connections) {
            adj.computeIfAbsent(connection[0], k -> new ArrayList<>()).add(List.of(connection[1], 1));
            adj.computeIfAbsent(connection[1], k -> new ArrayList<>()).add(List.of(connection[0], 0));
        }

        return dfs(0, -1, adj);
    }

    private int dfs(int node, int prevNode, Map<Integer, List<List<Integer>>> adj) {
        if (!adj.containsKey(node)) {
            return 0;
        }

        int reorderCount = 0;

        for (List<Integer> childPair : adj.get(node)) {
            int child = childPair.get(0);
            int sign = childPair.get(1);

            if (child != prevNode){
                reorderCount += sign;
                reorderCount += dfs(child, node, adj);
            }
        }

        return reorderCount;
    }
}
