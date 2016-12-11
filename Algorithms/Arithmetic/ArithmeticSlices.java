public class Solution {
    public int numberOfArithmeticSlices(int[] A) 
    {
        int arrlength=A.length-1;
        int diff=0,j=0,count=0;
        for(int i=0;i<arrlength;i++)
                {        
                   diff=A[i+1]-A[i];//
                   j=i+2;
                   while((j<=arrlength) && (A[i]+diff*(j-i))==A[j])
                    {
                      count++;
                      j++;  
                    }
                    
                }    
                return count;
    }
}