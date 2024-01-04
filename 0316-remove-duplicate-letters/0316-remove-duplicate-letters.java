import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        Map<Character, Boolean> seen = new HashMap<>();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            counter.put(c, counter.get(c) - 1);

            if (seen.containsKey(c) && seen.get(c)) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
                seen.put(stack.pop(), false);
            }
            stack.push(c);
            seen.put(c, true);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        sb.reverse();
        return sb.toString();
    }
}