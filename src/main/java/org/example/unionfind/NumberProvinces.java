package org.example.unionfind;

import java.util.Arrays;
import java.util.stream.Collectors;

public class NumberProvinces {
    public int findCircleNum(int[][] isConnected) {
        UnionFind u = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    u.union(i, j);
                }
            }
        }

        return u.size;
    }

    class UnionFind {
        private int[] rank;
        private int[] root;
        private int size;

        public UnionFind(int size) {
            rank = new int[size];
            root = new int[size];
            this.size = size;

            for (int i = 0; i < root.length; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int x) {
            if (root[x] == x) {
                return x;
            }

            return root[x] = find(root[x]);
        }

        private void union(int x, int y) {
            if (x == y) {
                return;
            }
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
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
        }
    }
}
