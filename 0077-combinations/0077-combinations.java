import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(1, n, k, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int index, int n, int k, LinkedList<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
        }

        for (int i = index; i <= n; i++) {
            current.addLast(i);
            dfs(i + 1, n, k, current, result);
            current.pollLast();
        }
    }
}