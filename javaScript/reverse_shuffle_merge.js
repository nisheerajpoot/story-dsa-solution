function reverseShuffleMerge(s) {
    // Frequency array for 26 lowercase letters
    const freq = new Array(26).fill(0);
    for (let i = 0; i < s.length; i++) {
        freq[s.charCodeAt(i) - 97]++;
    }
    
    // Need half of each character
    const need = new Array(26);
    for (let i = 0; i < 26; i++) {
        need[i] = freq[i] / 2;
    }
    
    // Track used and remaining
    const used = new Array(26).fill(0);
    const remaining = [...freq];
    
    // Stack for result
    const stack = [];
    
    // Traverse from end
    for (let i = s.length - 1; i >= 0; i--) {
        const ch = s[i];
        const idx = ch.charCodeAt(0) - 97;
        remaining[idx]--;
        
        if (used[idx] >= need[idx]) {
            continue;
        }
        
        while (stack.length > 0) {
            const top = stack[stack.length - 1];
            const topIdx = top.charCodeAt(0) - 97;
            if (top > ch && remaining[topIdx] > need[topIdx] - used[topIdx]) {
                stack.pop();
                used[topIdx]--;
            } else {
                break;
            }
        }
        
        stack.push(ch);
        used[idx]++;
    }
    
    return stack.join('');
}