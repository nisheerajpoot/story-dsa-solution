
class  plates_between_candles {
public:
    vector<int> platesBetweenCandles(string s, vector<vector<int>>& queries) {
        int n = s.length();
        
        // Prefix sum for plates
        vector<int> prefix(n + 1, 0);
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s[i] == '*' ? 1 : 0);
        }
        
        // Nearest candle to the left
        vector<int> leftCandle(n, -1);
        int lastCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s[i] == '|') lastCandle = i;
            leftCandle[i] = lastCandle;
        }
        
        // Nearest candle to the right
        vector<int> rightCandle(n, -1);
        int nextCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == '|') nextCandle = i;
            rightCandle[i] = nextCandle;
        }
        
        vector<int> answer;
        for (auto& q : queries) {
            int L = q[0];
            int R = q[1];
            
            int left = rightCandle[L];   // First candle from left
            int right = leftCandle[R];   // Last candle from right
            
            if (left != -1 && right != -1 && left < right) {
                answer.push_back(prefix[right + 1] - prefix[left + 1]);
            } else {
                answer.push_back(0);
            }
        }
        
        return answer;
    }
};

