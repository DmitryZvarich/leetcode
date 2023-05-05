package org.example.unionfind;

public class RemoveMaxNumberEdgesKeepGraphFullyTraversable {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU aliceDSU = new DSU(n);
        DSU bobDSU = new DSU(n);

        int req = 0;

        for (int[] edge : edges) {
            if (edge[0] == 3) {
                req += aliceDSU.union(edge[1], edge[2]) | bobDSU.union(edge[1], edge[2]);
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                req += aliceDSU.union(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                req += bobDSU.union(edge[1], edge[2]);
            }
        }

        if (aliceDSU.isConnected() && bobDSU.isConnected()){
            return edges.length - req;
        }

        return -1;
    }

    static class DSU {
        private final int[] root;
        private final int[] rank;
        private int size;

        public DSU(int size) {
            root = new int[size + 1];
            for (int i = 0; i <= size; i++) {
                root[i] = i;
            }

            rank = new int[size + 1];
            this.size = size;
        }

        public int find(int x) {
            if (root[x] == x) {
                return x;
            }

            return root[x] = find(root[x]);
        }

        public int union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return 0;
            }

            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }

            size--;
            return 1;
        }

        public boolean isConnected() {
            return size == 1;
        }
    }
}
