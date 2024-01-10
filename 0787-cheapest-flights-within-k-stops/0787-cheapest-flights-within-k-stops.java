import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        Map<Integer, Integer> numberOfStops = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            Map<Integer, Integer> edges = map.get(flight[0]);
            edges.put(flight[1], flight[2]);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[1]));
        pq.add(new int[]{src, 0, -1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int city = cur[0];
            int price = cur[1];
            int stops = cur[2];

            
            if (stops > k) {
                continue;
            }
            if (city == dst) {
                return price;
            }
            if (numberOfStops.containsKey(city) && numberOfStops.get(city) < stops) {
                continue;
            }
            numberOfStops.put(city, stops);
            if (map.containsKey(city)) {
                for (Map.Entry<Integer, Integer> next : map.get(city).entrySet()) {
                    pq.add(new int[]{next.getKey(), price + next.getValue(), stops + 1});
                }
            }
        }

        return -1;
    }
}