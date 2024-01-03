import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int water = Math.min(height[stack.peek()], height[i]) - height[pop];
                result += distance * water;
            }
            stack.push(i);
        }
        return result;
    }
}