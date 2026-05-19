function binarySearchRight(arr, target) {
    let left = 0;
    let right = arr.length;
    
    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (arr[mid] <= target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}

function binarySearchLeft(arr, target) {
    let left = 0;
    let right = arr.length;
    
    while (left < right) {
        const mid = Math.floor((left + right) / 2);
        if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    return left;
}

function solve(shots, players) {
    const n = shots.length;
    const m = players.length;
    
    // Extract shot start and end points
    const starts = new Array(n);
    const ends = new Array(n);
    
    for (let i = 0; i < n; i++) {
        starts[i] = shots[i][0];
        ends[i] = shots[i][1];
    }
    
    // Sort for binary search
    starts.sort((a, b) => a - b);
    ends.sort((a, b) => a - b);
    
    let totalStrength = 0;
    
    for (let i = 0; i < m; i++) {
        const C = players[i][0];
        const D = players[i][1];
        
        // Count shots with start <= D
        const countStartBeforeEnd = binarySearchRight(starts, D);
        
        // Count shots with end < C
        const countEndBeforeStart = binarySearchLeft(ends, C);
        
        // Overlapping shots
        const overlap = countStartBeforeEnd - countEndBeforeStart;
        totalStrength += overlap;
    }
    
    return totalStrength;
}