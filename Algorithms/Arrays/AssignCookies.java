public class Solution 
{
    public int findContentChildren(int[] g, int[] s) 
    {
       Arrays.sort(g);
       Arrays.sort(s);
       int slength=s.length,glength=0,size=0;
       int garrlength=g.length;
       
       while(size<slength && glength<garrlength)
        {
            if(s[size]>=g[glength])
            {
               glength++;
            }
            size++;
            
        }
        return glength;
    }
}