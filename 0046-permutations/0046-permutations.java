import javax.swing.text.AttributeSet;
import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> remainNums = new HashSet<>();
        for (int n : nums) {
            remainNums.add(n);
        }

        dfs(new ArrayList<>(), remainNums, result);

        return result;
    }

    private void dfs(List<Integer> integers, Set<Integer> remainNums, List<List<Integer>> result) {
        if (remainNums.isEmpty()) {
            result.add(new ArrayList<>(integers));
            return;
        }

        for (int n : remainNums) {
            Set<Integer> nextRemain = new HashSet<>(remainNums);
            integers.add(n);
            nextRemain.remove(n);
            dfs(integers, nextRemain, result);
            integers.remove(integers.size() - 1);
        }
    }
}