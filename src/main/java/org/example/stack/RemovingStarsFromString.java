package org.example.stack;

import java.util.Stack;

public class RemovingStarsFromString {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
            } else {
                stack.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
