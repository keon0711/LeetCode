class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] canTake = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        Map<Integer, List<Integer>> courseMap = new HashMap<>();

        for (int[] p : prerequisites) {
            List<Integer> requiredCourses = courseMap.getOrDefault(p[0], new ArrayList<>());
            requiredCourses.add(p[1]);
            courseMap.putIfAbsent(p[0], requiredCourses);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, courseMap, canTake, visited))
                return false;
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> courseMap, boolean[] canTake, boolean[] visited) {
        if (visited[course]) {
            return canTake[course];
        }
        visited[course] = true;

        for (Integer preCourse : courseMap.getOrDefault(course, new ArrayList<>())) {
            if (!dfs(preCourse, courseMap, canTake, visited)) {
                return false;
            }
        }
        canTake[course] = true;
        return true;
    }
}