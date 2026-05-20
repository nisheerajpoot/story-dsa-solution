package java;

//import java.util.ArrayDeque;
import java.util.Stack;

public class reverseShuffleMerge {

    public static String reverseShuffleMerges(String s) {
        int n = s.length();
        
        // Count frequency of each character in s
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Each character in answer appears half the times
        int[] need = new int[26];
        for (int i = 0; i < 26; i++) {
            need[i] = freq[i] / 2;
        }
        
        // Stack to build the answer
        Stack<Character> stack = new Stack<>();
        
        // Track remaining characters and used characters
        int[] remaining = freq.clone();
        int[] used = new int[26];
        
        // Traverse from the end (reverse of s)
        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            
            // Decrement remaining count
            remaining[idx]--;
            
            // If we already have enough of this character in answer, skip
            if (used[idx] >= need[idx]) {
                continue;
            }
            
            // Greedy: pop from stack if we can get a smaller character
            while (!stack.isEmpty() && 
                   stack.peek() > ch && 
                   remaining[stack.peek() - 'a'] > need[stack.peek() - 'a'] - used[stack.peek() - 'a']) {
                char top = stack.pop();
                used[top - 'a']--;
            }
            
            // Add current character to stack
            stack.push(ch);
            used[idx]++;
        }
        
        // Convert stack to string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.reverse().toString();
    }
  
}
