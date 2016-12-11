public class Solution 
{
    public int majorityElement(int[] nums) 
    {
        Map<Integer,Integer> m=new HashMap<Integer,Integer>();
        int numslength=nums.length;
        int halfnumslength=numslength/2,val=0;
        for(int i=0;i<numslength;i++)
            {
                if(m.containsKey(nums[i]))
                    m.put(nums[i],m.get(nums[i])+1);
                else
                    m.put(nums[i],1);
            }   
        Iterator iter=m.keySet().iterator();
        Object o=null;
        while(iter.hasNext())
            {
                o=iter.next();
               val=((int)m.get(o));
               if(val>halfnumslength)
                return ((int)o);
            }
            return -1;
    }
}