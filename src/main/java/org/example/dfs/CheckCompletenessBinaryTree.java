package org.example.dfs;

import org.example.common.TreeNode;

public class CheckCompletenessBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        int cnt = getTreeCount(root);

        return dfs(root, 0, cnt);
    }

    private boolean dfs(TreeNode root, int index, int cnt) {
        if (root == null) {
            return true;
        }

        if (index >= cnt) {
            return false;
        }

        return dfs(root.left, 2 * index + 1, cnt) && dfs(root.right, 2 * index + 2, cnt);
    }

    private int getTreeCount(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + getTreeCount(root.left) + getTreeCount(root.right);
    }
}
