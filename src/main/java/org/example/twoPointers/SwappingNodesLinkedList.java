package org.example.twoPointers;

import org.example.common.ListNode;

public class SwappingNodesLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode front = head;
        ListNode end = head;
        ListNode cur = head;

        int cnt = 1;

        while (cur.next != null) {
            if (cnt == k) {
                front = cur;
                end = head;
            }

            cnt++;
            cur = cur.next;
            end = end.next;
        }


        int val = front.val;
        front.val = end.val;
        end.val = val;

        return head;
    }
}
