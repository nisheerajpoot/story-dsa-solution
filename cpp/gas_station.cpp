class gas_station
{
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        int n = gas.size();
        
        // Calculate total gas and total cost
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        
        // If total gas is less than total cost, impossible
        if (totalGas < totalCost) {
            return -1;
        }
        
        // Difference array and prefix sum
        vector<int> diff(n);
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        
        // Find minimum prefix sum position
        int minPrefix = 0;
        int currentSum = 0;
        int minIndex = 0;
        
        for (int i = 0; i < n; i++) {
            currentSum += diff[i];
            if (currentSum < minPrefix) {
                minPrefix = currentSum;
                minIndex = i + 1;
            }
        }
        
        return minIndex % n;
    }
};

