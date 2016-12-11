public class NumArray 
{

    int nums[];
    public NumArray(int[] nums) 
    {
        int numslength=nums.length;
        for(int i=1;i<numslength;i++)
            nums[i]+=nums[i-1];
        this.nums=nums;

    }

    public int sumRange(int i, int j)
    {
        int numslength=nums.length;
        if(i<0 || j>numslength)
            return 0;
            if(i==0)
                return nums[j];
       return nums[j]-nums[i-1];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);