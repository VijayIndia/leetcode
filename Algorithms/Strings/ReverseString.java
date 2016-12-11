public class Solution {
    public String reverseString(String s) 
    {
        StringBuffer str=new StringBuffer(s);
        str=str.reverse();
        s=new String(str);
        return s;    
    }
}