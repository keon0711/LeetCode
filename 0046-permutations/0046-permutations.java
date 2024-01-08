import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(0, nums, new LinkedList<>(), result);

        return result;
    }

    private void dfs(int index, int[] nums, LinkedList<Integer> current,List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(index, i, nums);
            current.addLast(nums[index]);
            dfs(index + 1, nums, current, result);
            current.pollLast();
            swap(index, i, nums);
        }
    }

    private void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}