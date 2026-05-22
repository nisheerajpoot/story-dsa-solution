package java;

public class platesBetweenCandles {
     public int[] platesBetweenCandle(String s, int[][] queries) {
         int n = s.length();
        
        // Precompute arrays
        int[] prefix = new int[n + 1];
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        
        // Single forward pass for prefix and left candle
        int lastCandle = -1;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '*' ? 1 : 0);
            if (s.charAt(i) == '|') lastCandle = i;
            leftCandle[i] = lastCandle;
        }
        
        // Reverse pass for right candle
        int nextCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') nextCandle = i;
            rightCandle[i] = nextCandle;
        }
        
        // Process queries with direct array access
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int left = rightCandle[q[0]];
            int right = leftCandle[q[1]];
            
            if (left != -1 && right != -1 && left < right) {
                answer[i] = prefix[right] - prefix[left + 1];
            }
        }
        return answer;
    }
}
