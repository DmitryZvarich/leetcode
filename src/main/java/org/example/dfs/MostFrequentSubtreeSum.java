package org.example.dfs;

import org.example.common.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class MostFrequentSubtreeSum {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        int max = map.values().stream().mapToInt(k -> k).max().orElse(0);

        Set<Integer> collect = map.entrySet().stream()
                .filter(e -> e.getValue() == max)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        int[] res = new int[collect.size()];

        int ind = 0;

        for (int r : collect) {
            res[ind++] = r;
        }

        return res;
    }

    private int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null){
            return 0;
        }

        int s = root.val + dfs(root.left, map) + dfs(root.right, map);

        map.put(s, map.getOrDefault(s, 0) + 1);

        return s;
    }
}
