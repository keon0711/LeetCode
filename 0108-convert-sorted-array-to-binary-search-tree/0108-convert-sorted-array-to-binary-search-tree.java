import java.util.Arrays;

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        Arrays.sort(nums);
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        TreeNode parent = new TreeNode(nums[mid]);
        if (start > end) {
            return null;
        }

        parent.left = dfs(nums, start, mid - 1);
        parent.right = dfs(nums, mid + 1, end);

        return parent;
    }
}