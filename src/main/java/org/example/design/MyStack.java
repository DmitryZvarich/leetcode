package org.example.design;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private final Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();

    }

    public void push(int x) {
        queue.add(x);
        for(int i=0;i<queue.size()-1;i++)
        {
            int t = queue.poll();
            queue.add(t);
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}
