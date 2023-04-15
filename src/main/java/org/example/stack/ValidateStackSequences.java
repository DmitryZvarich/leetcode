package org.example.stack;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int ptr = 0;

        for (int push : pushed) {
            stack.add(push);

            if (ptr >= popped.length) {
                return false;
            }

            while (ptr < popped.length && !stack.isEmpty() && popped[ptr] == stack.peek()) {
                stack.pop();
                ptr++;
            }
        }

        return stack.isEmpty();
    }
}
