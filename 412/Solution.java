import java.util.ArrayList;
public class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> ss = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            String s = "";
            if (i % 3 == 0)
                s += "Fizz";
            if (i % 5 == 0)
                s += "Buzz";
            if (s == "")
                ss.add("" + i);
            else
                ss.add(s);
        }
        return ss;
    }
}