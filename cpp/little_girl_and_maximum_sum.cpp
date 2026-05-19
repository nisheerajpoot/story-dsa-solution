#include <cstdio>
#include <algorithm>

using namespace std;

int main() {
    int n, q, l, r;
    scanf("%d%d", &n, &q);
    
    int a[200000];
    for (int i = 0; i < n; ++i) {
        scanf("%d", &a[i]);
    }
    
    int c[200001] = {0};  // Difference array
    
    while (q--) {
        scanf("%d%d", &l, &r);
        c[l - 1] += 1;   // Start of range
        c[r] -= 1;       // End of range + 1
    }
    
    // Prefix sum to get frequencies
    for (int i = 1; i < n; ++i) {
        c[i] += c[i - 1];
    }
    
    // Sort both arrays
    sort(a, a + n);
    sort(c, c + n);
    
    // Calculate maximum sum
    long long answer = 0;
    for (int i = 0; i < n; ++i) {
        answer += 1LL * a[i] * c[i];
    }
    
    printf("%I64d\n", answer);
    
    return 0;
}