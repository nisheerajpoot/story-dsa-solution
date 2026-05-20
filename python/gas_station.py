from typing import List

class gas_station:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        
        # Calculate total gas and total cost
        total_gas = sum(gas)
        total_cost = sum(cost)
        
        # If total gas is less than total cost, impossible
        if total_gas < total_cost:
            return -1
        
        # Difference array and prefix sum
        diff = [gas[i] - cost[i] for i in range(n)]
        
        # Find minimum prefix sum position
        min_prefix = 0
        current_sum = 0
        min_index = 0
        
        for i in range(n):
            current_sum += diff[i]
            if current_sum < min_prefix:
                min_prefix = current_sum
                min_index = i + 1
        
        return min_index % n