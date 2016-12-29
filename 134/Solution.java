public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int front = 0;
        int totalFrom0 = 0;
        int totalFromStart = 0;
        int start = 0;
        while (front != n){
            totalFromStart += (gas[front] - cost[front]);
            front++;
            if (totalFromStart < 0){
                totalFrom0 += totalFromStart;
                start = front;
                totalFromStart = 0;
            }
        }
        if (start != n && totalFromStart + totalFrom0 >= 0)
            return start;
        else
            return -1;
    }
}