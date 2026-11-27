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

    int maxPathSum=Integer.MIN_VALUE;

    public int sum(TreeNode root){

        if(root==null){
            return 0;
        }

        int lh = Math.max(0,sum (root.left));
        int rh = Math.max(0,sum(root.right));

        int leftsum = lh+root.val;

        int rightsum = rh+root.val;

        maxPathSum=Math.max(maxPathSum,Math.max(Math.max(leftsum,rightsum),lh+rh+root.val));

        return Math.max(leftsum,rightsum);
    }
    public int maxPathSum(TreeNode root) {
        
        sum(root);

        return maxPathSum;
    }
}