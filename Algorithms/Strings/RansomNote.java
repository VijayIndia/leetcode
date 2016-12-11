public class Solution {
    public boolean canConstruct(String ransomNote, String magazine)
    {
        int count=0;
        char ransom_ch[]=ransomNote.toCharArray();
        char magazine_ch[]=magazine.toCharArray();
        Arrays.sort(ransom_ch);
        Arrays.sort(magazine_ch);
        int ransom_ch_length=ransom_ch.length;
        int magazine_ch_length=magazine_ch.length;
        for(int i=0;i<magazine_ch_length && count<ransom_ch_length;i++)
            {
                if(ransom_ch[count]==magazine_ch[i])
                    count++;
            }
            if(count==ransom_ch_length)
                return true;
        return false;
    }
}