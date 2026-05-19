#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int tc;
    cin >> tc;    // Reading number of test cases
    
    while (tc--) {
        int n;
        cin >> n;    // Reading size of arrays
        
        vector<long long> A(n), B(n);
        
        // Reading array A
        for (int i = 0; i < n; i++) {
            cin >> A[i];
        }
        
        // Reading array B
        for (int i = 0; i < n; i++) {
            cin >> B[i];
        }
        
        int i = 0, j = 0;
        int maxMonkiness = 0;
        
        // Two pointer approach
        while (i < n && j < n) {
            if (B[j] >= A[i]) {
                maxMonkiness = max(maxMonkiness, j - i);
                j++;
            } else {
                i++;
            }
        }
        
        cout << maxMonkiness << endl;
    }
    
    return 0;
}