import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.Math.*;

class Solution {
    public static class Point {
        double distance;
        int[] point;

        public Point(double distance, int[] point) {
            this.distance = distance;
            this.point = point;
        }

        public double getDistance() {
            return distance;
        }

        public int[] getPoint() {
            return point;
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(a -> a.getDistance()));
        
        for (int[] point : points) {
            double dist = sqrt(pow(point[0], 2) + pow(point[1], 2));
            pq.offer(new Point(dist, point));
        }

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getPoint();
        }
        return result;
    }
}