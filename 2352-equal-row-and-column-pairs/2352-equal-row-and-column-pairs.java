import java.util.ArrayList;
import java.util.List;

class Solution {
    public int equalPairs(int[][] grid) {
        List<List<Integer>> rows = new ArrayList<>();
        List<List<Integer>> cols = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            rows.add(new ArrayList<>());
            cols.add(new ArrayList<>());
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                rows.get(i).add(grid[i][j]);
                cols.get(j).add(grid[i][j]);
            }
        }

        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (rows.get(i).equals(cols.get(j))) {
                    result++;
                }
            }
        }
        return result;
    }
}