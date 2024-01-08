class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, target, new LinkedList<>(), candidates, result);
        return result;
    }

    private void dfs(int index, int target, LinkedList<Integer> comb, int[] candidates, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            comb.add(candidates[i]);
            dfs(i, target - candidates[i], comb, candidates, result);
            comb.pollLast();
        }
    }
}