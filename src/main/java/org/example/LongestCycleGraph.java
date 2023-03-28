package org.example;

public class LongestCycleGraph {
    public int longestCycle(int[] edges) {
        boolean[] visited = new boolean[edges.length];
        int res = -1;

        for (int i = 0; i < edges.length; i++) {
            int fast = getCycle(i, edges, visited);

            if (fast == -1) {
                continue;
            }

            int size = 1;
            int pos = edges[fast];
            while (pos != fast) {
                size++;
                pos = edges[pos];
            }

            res = Math.max(res, size);
        }
        return res;
    }

    private int getCycle(int node, int[] edges, boolean[] visited) {
        int slow = node;
        int fast = edges[node];

        while (slow != fast) {
            if (visited[slow] || fast == -1 || edges[fast] == -1){
                return -1;
            }

            visited[slow] = true;

            slow = edges[slow];
            fast = edges[edges[fast]];
        }

        return fast;
    }
}
