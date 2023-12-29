import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> result = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]
        );
        for (int[] p : people) {
            pq.offer(p);
        }
        for (int i = 0; i < people.length; i++) {
            int[] person = pq.poll();
            result.add(person[1], person);
        }
        
        return result.toArray(new int[people.length][2]);
    }
}