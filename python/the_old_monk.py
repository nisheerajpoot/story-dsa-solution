# Read number of test cases
tc = int(raw_input())

for _ in range(tc):
    # Read size of arrays
    n = int(raw_input())
    
    # Read array A
    A = map(int, raw_input().split())
    
    # Read array B
    B = map(int, raw_input().split())
    
    # Two pointer approach
    i = 0
    j = 0
    max_monkiness = 0
    
    while i < n and j < n:
        if B[j] >= A[i]:
            max_monkiness = max(max_monkiness, j - i)
            j += 1
        else:
            i += 1
    
    # Print result
    print(max_monkiness)