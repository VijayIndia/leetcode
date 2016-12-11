public class Solution 
{
    public int sumOfLeftLeaves(TreeNode root)
    {
        int lval=0;
        if(root==null)
            return 0;
        if(root.left!=null  && root.left.left==null && root.left.right==null)
            lval=root.left.val;
        lval+=sumOfLeftLeaves(root.left);
        lval+=sumOfLeftLeaves(root.right);
        return lval;
    }
}