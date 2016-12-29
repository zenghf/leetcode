public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] acc = new int[n];
        int sum = 0;
        int firstNegative = 0;
        for (int i = 0; i < n; i++){
            int temp = gas[i] - cost[i];
            acc[i] = temp;
            sum += temp;
            if (temp < 0)
                firstNegative = i;
        }
        if (acc[firstNegative] > 0)
            return 0;
        if (sum < 0)
            return -1;
        int negativeUntil = (firstNegative + 1) % n;
        int totalNegative = acc[firstNegative];
        int total = 0;
        int start = negativeUntil;
        int front = negativeUntil;
        while (front != firstNegative){
            total += acc[front];
            front = (front + 1) % n;
            if (total < 0){
                totalNegative += total;
                negativeUntil = front;
                start = front;
                total = 0;
            }
        }
        return start;
    }
}