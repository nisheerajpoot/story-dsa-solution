def solve(shots, players):
    n = len(shots)
    m = len(players)
    
    # Extract shot start and end points
    starts = [shot[0] for shot in shots]
    ends = [shot[1] for shot in shots]
    
    # Sort for binary search
    starts.sort()
    ends.sort()
    
    total_strength = 0
    
    for player in players:
        C = player[0]
        D = player[1]
        
        # Count shots with start <= D
        count_start_before_end = bisect.bisect_right(starts, D)
        
        # Count shots with end < C
        count_end_before_start = bisect.bisect_left(ends, C)
        
        # Overlapping shots
        overlap = count_start_before_end - count_end_before_start
        total_strength += overlap
    
    return total_strength