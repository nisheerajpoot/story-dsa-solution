package java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class theOldMonk {
    
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        
        while (tc-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());

            String[] aInput = br.readLine().trim().split(" ");
            long[] A = new long[n];
            for (int i = 0; i < n; i++) {
                A[i] = Long.parseLong(aInput[i]);
            }

            String[] bInput = br.readLine().trim().split(" ");
            long[] B = new long[n];
            for (int i = 0; i < n; i++) {
                B[i] = Long.parseLong(bInput[i]);
            }

            int i = 0, j = 0;
            int maxMonkiness = 0;
            
            while (i < n && j < n) {
                if (B[j] >= A[i]) {
                    maxMonkiness = Math.max(maxMonkiness, j - i);
                    j++;
                } else {
                    i++;
                }
            }

            System.out.println(maxMonkiness);
        }
    }

}
