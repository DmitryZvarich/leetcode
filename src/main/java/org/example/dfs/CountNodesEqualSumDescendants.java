package org.example.dfs;

import org.example.common.TreeNode;

public class CountNodesEqualSumDescendants {
    int cnt;
    public int equalToDescendants(TreeNode root) {
        cnt = 0;

        dfs(root);

        return cnt;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int s = dfs(root.left) + dfs(root.right);

        if (root.val == s) {
            cnt++;
        }

        return s + root.val;
    }
}
