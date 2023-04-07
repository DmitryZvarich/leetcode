package org.example.design;

import org.example.common.TreeNode;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        dfs_left(root);
    }

    private void dfs_left(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode pop = stack.pop();
        dfs_left(pop.right);
        return pop.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
