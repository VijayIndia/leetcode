public class Solution {
    public boolean isAnagram(String s, String t) 
    {
        s=s.trim();
        t=t.trim();
        char cs[]=s.toCharArray();
        char ct[]=t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        s=String.valueOf(cs);
        t=String.valueOf(ct);
        if(s.equals(t))
            return true;
        else
            return false;
    }
}