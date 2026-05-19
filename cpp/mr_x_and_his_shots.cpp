#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int solve(vector<vector<int>> shots, vector<vector<int>> players) {
    int n = shots.size();
    int m = players.size();
    
    // Extract shot start and end points
    vector<int> starts(n), ends(n);
    for (int i = 0; i < n; i++) {
        starts[i] = shots[i][0];
        ends[i] = shots[i][1];
    }
    
    // Sort for binary search
    sort(starts.begin(), starts.end());
    sort(ends.begin(), ends.end());
    
    long long totalStrength = 0;
    
    for (int i = 0; i < m; i++) {
        int C = players[i][0];
        int D = players[i][1];
        
        // Count shots with start <= D
        int countStartBeforeEnd = upper_bound(starts.begin(), starts.end(), D) - starts.begin();
        
        // Count shots with end < C
        int countEndBeforeStart = lower_bound(ends.begin(), ends.end(), C) - ends.begin();
        
        // Overlapping shots
        int overlap = countStartBeforeEnd - countEndBeforeStart;
        totalStrength += overlap;
    }
    
    return totalStrength;
}