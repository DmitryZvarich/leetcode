package org.example.linkedList;

import org.example.common.ListNode;

public class LinkedListCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode n = isCycleExists(head);
        if (n == null) {
            return null;
        }

        while (head != n) {
            head = head.next;
            n = n.next;
        }

        return n;
    }

    private ListNode isCycleExists(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow.equals(fast)) {
                return fast;
            }
        }

        return null;
    }
}
