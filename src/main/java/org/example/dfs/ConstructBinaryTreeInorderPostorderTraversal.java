package org.example.dfs;

import org.example.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeInorderPostorderTraversal {
    private Map<Integer, Integer> inorderIndex;
    private int[] inorder;
    private int[] postorder;
    private int postInd;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        postInd = postorder.length - 1;

        inorderIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right){
        if (left > right){
            return null;
        }

        int val = postorder[postInd];
        TreeNode node = new TreeNode(val);
        postInd--;

        Integer integer = inorderIndex.get(val);

        node.right = helper(integer + 1, right);
        node.left = helper(left, integer - 1);

        return node;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }

    private void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.println(root.val);
    }
}
