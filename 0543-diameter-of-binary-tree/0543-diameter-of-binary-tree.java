class Solution {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
    
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDist = 0;
        int rightDist = 0;
        if (root.left != null) {
            leftDist = dfs(root.left) + 1;
        }
        if (root.right != null) {
            rightDist = dfs(root.right) + 1;
        }
        diameter = Math.max(diameter, leftDist + rightDist);
        return Math.max(leftDist, rightDist);
    }
}