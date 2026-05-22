package java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class theOldMonk {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int tc = Integer.parseInt(br.readLine().trim());
        StringBuilder output = new StringBuilder();
        
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            
            // Read array A
            long[] A = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                A[i] = Long.parseLong(st.nextToken());
            }
            
            // Read array B
            long[] B = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                B[i] = Long.parseLong(st.nextToken());
            }
            
            // Binary search for each i
            int maxMonkiness = 0;
            for (int i = 0; i < n; i++) {
                int left = i, right = n - 1, ans = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (B[mid] >= A[i]) {
                        ans = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                if (ans != -1) {
                    maxMonkiness = Math.max(maxMonkiness, ans - i);
                }
            }
            
            output.append(maxMonkiness).append("\n");
        }
        
        System.out.print(output);
    }
}