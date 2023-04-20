package org.example.dfs;

import org.example.common.TreeNode;

import java.util.*;

public class MaximumWidthBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        dfs(root, 0, 0, map);

        int res = 0;

        for (int level : map.keySet()) {
            List<Integer> weights = map.get(level);

            res = Math.max(res, weights.get(weights.size() - 1) - weights.get(0) + 1);
        }

        return res;
    }

    private void dfs(TreeNode root, int level, int weight, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }

        map.computeIfAbsent(level, k -> new ArrayList<>()).add(weight);

        dfs(root.left, level + 1, weight * 2, map);
        dfs(root.right, level + 1, weight * 2 + 1, map);
    }
}
