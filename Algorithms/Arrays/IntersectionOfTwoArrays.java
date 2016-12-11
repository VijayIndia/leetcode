public class Solution 
{
    public int[] intersection(int[] nums1, int[] nums2) 
    {
        Set<Integer> result=new HashSet<Integer>();
        int num1length=nums1.length,num2length=nums2.length;
        int i=0,j=0,k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<num1length && j<num2length)
        {
            if(nums1[i]==nums2[j])
               {
                   result.add(nums1[i]);
                   i++;
                   j++;
               }
            else if(nums1[i]<nums2[j])
                i++;
            else if(nums1[i]>nums2[j])
                j++;
        }
        int arrsize=result.size();
        int output[]=new int[arrsize];
        Iterator iter=result.iterator();
        while(iter.hasNext())
                {
                    output[k]=((int)iter.next());
                    k++;
                }
      return output;
    }
}