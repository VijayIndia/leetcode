/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) 
    {
        if(root==null)
            return null;
        TreeNode temp_left=root.left,temp_right=root.right;
        root.right=invertTree(temp_left);
        root.left=invertTree(temp_right);
       return root;
    }
}