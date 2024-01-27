class Solution {
    int longestPath = 0;

    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return longestPath;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left) + 1;
        int right = dfs(node.right) + 1;
        int leftDist = 0;
        int rightDist = 0;

        if (node.left != null && node.val == node.left.val) {
            leftDist = left;
        }
        if (node.right != null && node.val == node.right.val) {
            rightDist = right ;
        }
        longestPath = Math.max(longestPath, leftDist + rightDist);
        return Math.max(leftDist, rightDist);
    }
}