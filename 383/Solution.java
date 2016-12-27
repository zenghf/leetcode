public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;
        int[] hist = new int[26];
        for (char ch : magazine.toCharArray())
            hist[ch - 'a']++;
        for (char ch : ransomNote.toCharArray()){
            if (--hist[ch - 'a'] < 0)
                return false;
        }
        return true;
    }
}