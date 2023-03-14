package org.example.dfs;

import org.example.common.TreeNode;

public class SumRootLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int res = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return res;
        }

        return helper(root.left, res) + helper(root.right, res);
    }
}
