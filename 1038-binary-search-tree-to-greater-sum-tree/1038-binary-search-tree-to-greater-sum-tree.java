class Solution {
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public int dfs(TreeNode node, int cumulativeSum) {
        if (node.right != null) {
            node.val += dfs(node.right, cumulativeSum);
        } else {
            node.val += cumulativeSum;
        }

        if (node.left == null) {
            return node.val;
        }
        return dfs(node.left, node.val);
    }
}