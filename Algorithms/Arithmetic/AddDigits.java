public class Solution {
    public int addDigits(int num) 
    {
            while(num>=10)
            {
                    int value=0;
                    while(num>0)
                    {
                        value+=num%10;
                        num=num/10;
                    }
                    num=value;
            }
            
            return num;
        
    }
}