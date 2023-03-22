package org.example.dfs;

import org.example.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorderTraversal {
    private int[] preorder;
    private int[] inorder;
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++){
            inorderIndexMap.put(inorder[i], i);
        }

        return helper(0, inorder.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if (left > right){
            return null;
        }

        int val = preorder[preorderIndex++];
        TreeNode root = new TreeNode(val);
        Integer ind = inorderIndexMap.get(val);
        root.left = helper(left, ind - 1);
        root.right = helper(ind + 1, right);
        return root;
    }
}
