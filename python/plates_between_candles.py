class plater_between_candles :
    def platesBetweenCandles(self, s: str, queries: List[List[int]]) -> List[int]:
        n = len(s)
        
        # Prefix sum for plates
        prefix = [0] * (n + 1)
        for i, ch in enumerate(s):
            prefix[i + 1] = prefix[i] + (1 if ch == '*' else 0)
        
        # Nearest candle to the left
        left_candle = [-1] * n
        last_candle = -1
        for i, ch in enumerate(s):
            if ch == '|':
                last_candle = i
            left_candle[i] = last_candle
        
        # Nearest candle to the right
        right_candle = [-1] * n
        next_candle = -1
        for i in range(n - 1, -1, -1):
            if s[i] == '|':
                next_candle = i
            right_candle[i] = next_candle
        
        answer = []
        for L, R in queries:
            left = right_candle[L]
            right = left_candle[R]
            
            if left != -1 and right != -1 and left < right:
                answer.append(prefix[right + 1] - prefix[left + 1])
            else:
                answer.append(0)
        
        return answer