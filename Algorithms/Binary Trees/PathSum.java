public class Solution 
{
    public boolean hasPathSum(TreeNode root, int sum) 
    {
        int flag=0;
        boolean left=false,right=false;
        if(root==null)
            return false;
   
        if(root.left!=null)
            {
            flag=1;
            left=hasPathSum(root.left,sum-root.val);
            }
        if(root.right!=null)
            {
            flag=1;
            right=hasPathSum(root.right,sum-root.val);
            }
        if(flag==0 && root.val==sum)
            return true;
            if(left || right)
                return true;
        return false;
        
    }
}