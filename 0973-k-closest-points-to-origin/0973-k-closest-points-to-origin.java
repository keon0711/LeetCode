import java.util.PriorityQueue;

import static java.lang.Math.*;

class Solution {
    public double calcDist(int[] point) {
        return sqrt(pow(point[0], 2) + pow(point[1], 2));
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> calcDist(a) < calcDist(b) ? -1 : 1);
        for (int[] point : points) {
            pq.offer(point);
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}