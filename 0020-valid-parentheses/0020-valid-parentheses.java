import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == pair(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private Character pair(char c) {
        if (c == ')') {
            return '(';
        }
        if (c == '}') {
            return '{';
        }
        if (c == ']') {
            return '[';
        }
        return ' ';
    }
}