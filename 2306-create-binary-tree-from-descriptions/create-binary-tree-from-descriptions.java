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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        
        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            boolean isLeft = desc[2] == 1;
            
            nodes.putIfAbsent(parent, new TreeNode(parent));
            nodes.putIfAbsent(child, new TreeNode(child));
            
            if (isLeft) {
                nodes.get(parent).left = nodes.get(child);
            } else {
                nodes.get(parent).right = nodes.get(child);
            }
            
            children.add(child);
        }
        
        for (int nodeVal : nodes.keySet()) {
            if (!children.contains(nodeVal)) {
                return nodes.get(nodeVal);
            }
        }
        
        return null;
    }
}