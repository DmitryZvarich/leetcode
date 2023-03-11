package org.example.linkedList;

import org.example.common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LinkedListRandomNode382 {
    List<Integer> list;
    public LinkedListRandomNode382(ListNode head) {
        list = new ArrayList<>();

        while (head != null){
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        Random r = new Random();
        int ind = r.nextInt(list.size());
        return list.get(ind);
    }
}
