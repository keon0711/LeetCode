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
    public int goodNodes(TreeNode root) {
        List<TreeNode> goodNodes = new ArrayList<>();
        findGoodNodes(root, goodNodes, new ArrayList<>());
        return goodNodes.size();
    }

    private void findGoodNodes(TreeNode node, List<TreeNode> goodNodes, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        Integer maxValue = path.stream().max(Integer::compareTo).orElse(Integer.MIN_VALUE);
        if (node.val >= maxValue) {
            System.out.println(node.val);
            goodNodes.add(node);
        }
        path.add(node.val);
        findGoodNodes(node.left, goodNodes, path);
        findGoodNodes(node.right, goodNodes, path);
        path.remove(path.size() - 1);
    }
}