package org.example;

import org.example.common.ListNode;
import org.example.common.TreeNode;

public class ConvertSortedListBinarySearchTree109 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        TreeNode node = new TreeNode(slow.val);

        if(head == slow){
            return node;
        }

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(slow.next);

        return node;
    }
}
