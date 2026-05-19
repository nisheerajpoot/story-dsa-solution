def reverseShuffleMerge(s):
    # Count frequency of each character in s
    freq = Counter(s)
    
    # Each character in answer appears half the times
    need = {c: freq[c] // 2 for c in freq}
    
    # Track used characters and remaining characters
    used = {c: 0 for c in freq}
    remaining = dict(freq)
    
    # Stack to build the answer
    stack = []
    
    # Traverse from the end (reverse of s)
    for ch in reversed(s):
        remaining[ch] -= 1
        
        # If we already have enough of this character, skip
        if used[ch] >= need[ch]:
            continue
        
        # Greedy: pop from stack if we can get a smaller character
        while (stack and stack[-1] > ch and 
               remaining[stack[-1]] > need[stack[-1]] - used[stack[-1]]):
            top = stack.pop()
            used[top] -= 1
        
        # Add current character to stack
        stack.append(ch)
        used[ch] += 1
    
    return ''.join(stack)