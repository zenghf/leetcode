import java.util.HashSet;

public class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        for (char ch : new char[] {'a', 'e', 'i', 'o', 'u'})
            vowels.add(ch);
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = s.length() - 1;
        for(; left < right; left++, right--){
            while(left < right && !vowels.contains(Character.toLowerCase(sb.charAt(left))))
                left++;
            while(right > left && !vowels.contains(Character.toLowerCase(sb.charAt(right))))
                right--;
            if (left >= right)
                break;
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
        }
        return sb.toString();
    }
}