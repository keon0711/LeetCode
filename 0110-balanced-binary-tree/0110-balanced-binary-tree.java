class Solution {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return flag;
        }

        getHeight(root);
        return flag;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if (Math.abs(left - right) > 1) {
            flag = false;
        }
        return Math.max(left, right) + 1;
    }
}
