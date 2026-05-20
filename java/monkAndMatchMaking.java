package java;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class monkAndMatchMaking {
    public static void main(String args[]) throws Exception {
        // BufferedReader for fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Read the string
        String s = br.readLine();
        int n = s.length();
        
        // Base and modulus for rolling hash
        long base = 911382323;
        long mod = 1000000007;
        
        // Precompute powers
        long[] pow = new long[n + 2];
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * base) % mod;
        }
        
        // Compute prefix hashes
        long[] hash = new long[n + 2];
        hash[0] = 0;
        for (int i = 0; i < n; i++) {
            int val = s.charAt(i) - 'a' + 1;
            hash[i + 1] = (hash[i] * base + val) % mod;
        }
        
        // Read number of queries
        int q = Integer.parseInt(br.readLine());
        
        // Process each query
        for (int i = 0; i < q; i++) {
            String[] parts = br.readLine().split(" ");
            int L1 = Integer.parseInt(parts[0]);
            int R1 = Integer.parseInt(parts[1]);
            int L2 = Integer.parseInt(parts[2]);
            int R2 = Integer.parseInt(parts[3]);
            
            // Check if lengths are different
            if ((R1 - L1) != (R2 - L2)) {
                System.out.println("No");
                continue;
            }
            
            // Calculate hash for first substring
            long h1 = hash[R1] - (hash[L1 - 1] * pow[R1 - L1 + 1]) % mod;
            h1 = (h1 + mod) % mod;
            
            // Calculate hash for second substring
            long h2 = hash[R2] - (hash[L2 - 1] * pow[R2 - L2 + 1]) % mod;
            h2 = (h2 + mod) % mod;
            
            if (h1 == h2) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}