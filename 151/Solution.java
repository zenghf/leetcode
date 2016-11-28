import java.util.ArrayList;

public class Solution {
    public String reverseWords(String s) {
        ArrayList<String> words = new ArrayList<>();
        char prev = ' ';
        StringBuilder word = new StringBuilder();
        for (char curr : s.toCharArray()){
            if (curr == ' '){
                if (prev != ' '){
                    words.add(word.toString());
                    word.setLength(0);
                }
            }
            else{
                word.append(curr);
            }
            prev = curr;
        }
        StringBuilder result = word;
        if (result.length() > 0)
            result.append(' ');
        for (int i = words.size() - 1; i >= 0; i--){
            result.append(words.get(i));
            result.append(' ');
        }
        System.out.println("words: " + words);
        System.out.println("result: '" + result + "'");
        if (result.length() > 0)
            result.setLength(result.length() - 1);
        System.out.println("'" + result.toString() + "'");
        return result.toString();
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        solution.reverseWords("a b");
    }
}