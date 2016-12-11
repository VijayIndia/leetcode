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
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        boolean left=false,right=false;
        if(p==null && q==null)
            return true;
        if(((p!=null && q==null) || (p==null && q!=null))||((p.left!=null && q.left==null) || (p.left==null && q.left!=null)) || ((p.right!=null && q.right==null) || (p.right==null && q.right!=null)))
                return false;
           if((p!=null && q!=null) && (p.val==q.val))
                {
                    left=isSameTree(p.left,q.left);
                    right=isSameTree(p.right,q.right);
                }
           if((left && right))
                return true;
        
        return false;
    }
}