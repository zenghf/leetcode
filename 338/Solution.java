public class Solution {
    public int[] countBits(int num) {
        int[] output = new int[num + 1];
        if (num == 0)
            return output;
        output[1] = 1;
        if (num == 1)
            return output;
        for (int k = 1; k < (num + 1) / 2; k++){
            output[k * 2] = output[k];
            output[k * 2 + 1] = output[k] + 1;
        }
        if (num % 2 == 0)
            output[num] = output[num / 2];
        return output;
    }
}