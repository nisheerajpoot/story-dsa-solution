package java;

public class gasStation {
     public int canCompleteCircuit(int[] gas, int[] cost) {
     int total = 0;
        int current = 0;
        int start = 0;
        int n = gas.length;
        
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            
            if (current < 0) {
                start = i + 1;
                current = 0;
            }
        }
        
        return total >= 0 ? start : -1;
    }
}
