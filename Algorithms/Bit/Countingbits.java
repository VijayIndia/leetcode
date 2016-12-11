public class Solution {
    public int[] countBits(int num) 
    {
         int count=0,j=0;
         int arr[]=new int[num+1];
        for(int i=0;i<=num;i++)
            {
                count=0;
                j=i;
                while(j>0)
                {
                   if(j%2==1)
                    {
                        count++;
                    }
                    j=j/2;
                }
                arr[i]=count;
            }
            return arr;
    }
}