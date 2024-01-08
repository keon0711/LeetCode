import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(int x, int y, char[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) {
                    continue;
                }

                if (map[nx][ny] == '1') {
                    q.add(new int[]{nx, ny});
                    map[nx][ny] = '0';
                }
            }
        }
    }
}