package java;

public class platesBetweenCandles {
     public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        
        // Prefix sum for plates
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '*' ? 1 : 0);
        }
        
        // Nearest candle to the left
        int[] leftCandle = new int[n];
        int lastCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') lastCandle = i;
            leftCandle[i] = lastCandle;
        }
        
        // Nearest candle to the right
        int[] rightCandle = new int[n];
        int nextCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') nextCandle = i;
            rightCandle[i] = nextCandle;
        }
        
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int L = queries[i][0];
            int R = queries[i][1];
            
            int left = rightCandle[L];
            int right = leftCandle[R];
            
            if (left != -1 && right != -1 && left < right) {
                answer[i] = prefix[right + 1] - prefix[left + 1];
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
}
