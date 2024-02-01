class Solution {
    int[] preorder;
    int[] inorder;
    int nodeIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        return dfs(0, preorder.length);
    }

    private TreeNode dfs(int start, int end) {
        if (start >= end || nodeIndex >= preorder.length) {
            System.out.println("empty array or out of bound");
            return null;
        }

        TreeNode node = new TreeNode(preorder[nodeIndex]);
        System.out.println(node.val + ", " + start + ", " + end);

        int mid = -1;
        for (int i = start; i < end; i++) {
            if (preorder[nodeIndex] == inorder[i]) {
                mid = i;
            }
        }
        if (mid == -1) {

            return null;
        }

        nodeIndex++;
        
        node.left = dfs(start, mid);
        node.right = dfs(mid + 1, end);
        
        return node;
    }
}