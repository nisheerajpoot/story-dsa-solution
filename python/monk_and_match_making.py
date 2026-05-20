import sys

def solve():
    input = sys.stdin.readline
    
    # Read the string
    s = input().strip()
    n = len(s)
    
    # Base and modulus for rolling hash
    base = 911382323
    mod = 1000000007
    
    # Precompute powers
    pow_arr = [1] * (n + 2)
    for i in range(1, n + 1):
        pow_arr[i] = (pow_arr[i - 1] * base) % mod
    
    # Compute prefix hashes
    hash_arr = [0] * (n + 2)
    for i in range(n):
        val = ord(s[i]) - ord('a') + 1
        hash_arr[i + 1] = (hash_arr[i] * base + val) % mod
    
    # Read number of queries
    q = int(input())
    
    # Process each query
    for _ in range(q):
        L1, R1, L2, R2 = map(int, input().split())
        
        # Check if lengths are different
        if (R1 - L1) != (R2 - L2):
            print("No")
            continue
        
        # Calculate hash for first substring
        h1 = (hash_arr[R1] - (hash_arr[L1 - 1] * pow_arr[R1 - L1 + 1]) % mod + mod) % mod
        
        # Calculate hash for second substring
        h2 = (hash_arr[R2] - (hash_arr[L2 - 1] * pow_arr[R2 - L2 + 1]) % mod + mod) % mod
        
        if h1 == h2:
            print("Yes")
        else:
            print("No")

if __name__ == "__main__":
    solve()