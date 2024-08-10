/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        findLeaves(root1, leaves1);
        for (int i = 0; i < leaves1.size(); i++) {
            System.out.print(leaves1.get(i) + ", ");
        }
        System.out.println();
        findLeaves(root2, leaves2);
        for (int i = 0; i < leaves2.size(); i++) {
            System.out.print(leaves2.get(i) + ", ");
        }
        System.out.println();

        if (leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (!leaves1.get(i).equals(leaves2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private void findLeaves(TreeNode node, List<Integer> leaves) {
        if (isLeaf(node)) {
            leaves.add(node.val);
            return;
        }
        
        if (node.left != null) {
            findLeaves(node.left, leaves);
        }
        if (node.right != null) {
            findLeaves(node.right, leaves);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}