/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
    const n = gas.length;
    
    // Calculate total gas and total cost
    let totalGas = 0;
    let totalCost = 0;
    for (let i = 0; i < n; i++) {
        totalGas += gas[i];
        totalCost += cost[i];
    }
    
    // If total gas is less than total cost, impossible
    if (totalGas < totalCost) {
        return -1;
    }
    
    // Difference array and prefix sum
    const diff = new Array(n);
    for (let i = 0; i < n; i++) {
        diff[i] = gas[i] - cost[i];
    }
    
    // Find minimum prefix sum position
    let minPrefix = 0;
    let currentSum = 0;
    let minIndex = 0;
    
    for (let i = 0; i < n; i++) {
        currentSum += diff[i];
        if (currentSum < minPrefix) {
            minPrefix = currentSum;
            minIndex = i + 1;
        }
    }
    
    return minIndex % n;
};