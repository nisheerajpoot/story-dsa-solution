package java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LittleGirlAndMaximumSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        Long[] arr = new Long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        long[] diff = new long[n + 2];
        
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            diff[l]++;
            diff[r + 1]--;
        }
        
        long[] freq = new long[n];
        long curr = 0;
        for (int i = 0; i < n; i++) {
            curr += diff[i];
            freq[i] = curr;
        }
        
        Arrays.sort(arr);
        Arrays.sort(freq);
        
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += arr[i] * freq[i];
        }
        
        System.out.println(maxSum);
    }
}