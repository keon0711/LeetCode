class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, new LinkedList<>(),result);
        return result;
    }

    private void dfs(int index, int[] nums, LinkedList<Integer> subset, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        subset.addLast(nums[index]);
        dfs(index + 1, nums, subset, result);
        subset.removeLast();
        dfs(index + 1, nums, subset, result);

    }
}