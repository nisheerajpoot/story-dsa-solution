package java;

import java.util.Arrays;
import java.util.List;

public class mrXAndHisShots {
public static int solve(List<List<Integer>> shots, List<List<Integer>> players) {
    int n = shots.size();
    int m = players.size();
    
    // Extract shot start and end points
    int[] starts = new int[n];
    int[] ends = new int[n];
    
    for (int i = 0; i < n; i++) {
        starts[i] = shots.get(i).get(0);
        ends[i] = shots.get(i).get(1);
    }
    
    // Sort for binary search
    Arrays.sort(starts);
    Arrays.sort(ends);
    
    long totalStrength = 0;
    
    for (int i = 0; i < m; i++) {
        int C = players.get(i).get(0);
        int D = players.get(i).get(1);
        
        // Count shots with start <= D
        int countStartBeforeEnd = upperBound(starts, D);
        
        // Count shots with end < C
        int countEndBeforeStart = lowerBound(ends, C);
        
        // Overlapping shots
        int overlap = countStartBeforeEnd - countEndBeforeStart;
        totalStrength += overlap;
    }
    
    return (int) totalStrength;
}

// Helper method for upper bound (first index > target)
private static int upperBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}

// Helper method for lower bound (first index >= target)
private static int lowerBound(int[] arr, int target) {
    int left = 0, right = arr.length;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}
    
}