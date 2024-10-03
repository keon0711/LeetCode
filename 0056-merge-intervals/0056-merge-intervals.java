import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        Deque<int[]> result = new ArrayDeque<>();
        for (int i = 0; i <intervals.length ; i++) {
            if (i == 0) {
                result.addLast(intervals[i]);
            } else if (result.peekLast()[1] >= intervals[i][0]) {
                int a = Math.min(result.peekLast()[0], intervals[i][0]);
                int b = Math.max(result.pollLast()[1], intervals[i][1]);
                result.add(new int[]{a, b});
            } else {
                result.add(intervals[i]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}