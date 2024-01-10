class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        for (int[] time : times) {
            map.putIfAbsent(time[0], new ArrayList<>());
            List<int[]> nextNodes = map.get(time[0]);
            nextNodes.add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0];
            int weight = poll[1];

            if (dist[node] == -1) {
                dist[node] = weight;
                if (!map.containsKey(node))
                    continue;
                for (int[] next : map.get(node)) {
                    pq.add(new int[]{next[0], weight + next[1]});
                }
            }
        }


        int result = -1;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == -1) {
                result = -1;
                break;
            }
            result = Integer.max(result, dist[i]);
        }
        return result;
    }
}