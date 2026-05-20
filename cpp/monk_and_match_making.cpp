#include <bits/stdc++.h>
using namespace std;

typedef long long ll;

const int MAXN = 1e5 + 5;
const ll BASE = 911382323;
const ll MOD = 1e9 + 7;

ll power[MAXN], hashS[MAXN];

void precompute() {
    power[0] = 1;
    for (int i = 1; i < MAXN; i++) {
        power[i] = (power[i - 1] * BASE) % MOD;
    }
}

void buildHash(string &s) {
    int n = s.length();
    hashS[0] = 0;
    for (int i = 0; i < n; i++) {
        hashS[i + 1] = (hashS[i] * BASE + (s[i] - 'a' + 1)) % MOD;
    }
}

ll getHash(int l, int r) {
    // l and r are 1-based inclusive
    return (hashS[r] - (hashS[l - 1] * power[r - l + 1]) % MOD + MOD) % MOD;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    precompute();

    string s;
    cin >> s;

    buildHash(s);

    int q;
    cin >> q;

    while (q--) {
        int L1, R1, L2, R2;
        cin >> L1 >> R1 >> L2 >> R2;

        ll hash1 = getHash(L1, R1);
        ll hash2 = getHash(L2, R2);

        if (hash1 == hash2 && (R1 - L1) == (R2 - L2)) {
            // Optional: Verify with direct comparison for safety (if needed)
            cout << "Yes\n";
        } else {
            cout << "No\n";
        }
    }

    return 0;
}