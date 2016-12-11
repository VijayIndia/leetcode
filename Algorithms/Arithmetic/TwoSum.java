public class Solution {
    public int[] twoSum(int[] nums, int target) 
    {
        Map<Integer,Integer> obj=new HashMap<Integer,Integer>();
        int numslength=nums.length;
        int result[]=new int[2];
        for(int i=0;i<numslength;i++)
            {
                if(obj.containsKey(target-nums[i]))
                    {
                        result[1]=i;
                        result[0]=obj.get(target-nums[i]);
                        return result;
                    }
                    obj.put(nums[i],i);
            }
            return result;
    }
}