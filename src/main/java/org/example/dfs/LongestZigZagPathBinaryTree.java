package org.example.dfs;

import org.example.common.TreeNode;

public class LongestZigZagPathBinaryTree {
    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root,true), dfs(root, false));
    }

    private int dfs(TreeNode root, boolean goRight) {
        if (root == null) {
            return -1;
        }

        TreeNode next = goRight ? root.right : root.left;

        return Math.max(1 + dfs(next, !goRight), dfs(next, goRight));
    }
}
