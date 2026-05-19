string reverseShuffleMerge(string s) {
    int n = s.length();
    
    // Count frequency of each character in s
    vector<int> freq(26, 0);
    for (char c : s) {
        freq[c - 'a']++;
    }
    
    // Each character in answer appears half the times
    vector<int> need(26, 0);
    for (int i = 0; i < 26; i++) {
        need[i] = freq[i] / 2;
    }
    
    // Stack to build the answer
    vector<char> result;
    
    // Track remaining characters and used characters
    vector<int> remaining(26, 0);
    remaining = freq;
    
    vector<int> used(26, 0);
    
    // Traverse from the end (reverse of s)
    for (int i = n - 1; i >= 0; i--) {
        char ch = s[i];
        int idx = ch - 'a';
        
        // Decrement remaining count
        remaining[idx]--;
        
        // If we already have enough of this character in answer, skip
        if (used[idx] >= need[idx]) {
            continue;
        }
        
        // Greedy: pop from stack if we can get a smaller character
        while (!result.empty() && 
               result.back() > ch && 
               remaining[result.back() - 'a'] > need[result.back() - 'a'] - used[result.back() - 'a']) {
            used[result.back() - 'a']--;
            result.pop_back();
        }
        
        // Add current character to result
        result.push_back(ch);
        used[idx]++;
    }
    
    // Convert result to string
    string answer(result.begin(), result.end());
    return answer;
}