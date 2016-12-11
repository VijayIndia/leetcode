public class Solution 
{
    public int firstUniqChar(String s) 
    {
        int slength=s.length();
        Map<Character,Integer> m=new LinkedHashMap<Character,Integer>();
        for(int i=0;i<slength;i++)
                {
                    if(m.containsKey(s.charAt(i)))
                        m.put(s.charAt(i),-1);
                    else
                        m.put(s.charAt(i),i);
                }
        List<Character> l=new LinkedList<Character>(m.keySet());
        Iterator iter=l.listIterator();
                    while(iter.hasNext())
                        {
                            char ch=(char)(iter.next());
                            if(m.get(ch)!=-1)
                                return m.get(ch); 
                        }
            return -1;
    }
}