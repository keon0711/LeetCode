class Solution {
    int minValue = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minValue;
    }

    private int[] dfs(TreeNode node) {
        int[] minAndMax = {node.val, node.val};

        if (node.left != null) {
            int[] leftSubTree = dfs(node.left);
            minAndMax[0] = leftSubTree[0];
            minValue = Math.min(minValue, Math.abs(node.val - leftSubTree[1]));
        }
        if (node.right != null) {
            int[] rightSubTree = dfs(node.right);
            minAndMax[1] = rightSubTree[1];
            minValue = Math.min(minValue, Math.abs(node.val - rightSubTree[0]));
        }

        return minAndMax;
    }
}