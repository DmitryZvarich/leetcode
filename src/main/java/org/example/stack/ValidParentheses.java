package org.example.stack;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    Map<Character, Character> map = Map.of('(', ')', '{', '}', '[', ']');

    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.add(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            Character pop = stack.pop();

            if (!map.get(pop).equals(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
