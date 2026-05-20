var platesBetweenCandles = function(s, n) {
    const len = s.length;
    
    // Prefix sum of plates (number of '*' up to index i)
    const prefixPlates = new Array(len + 1).fill(0);
    for (let i = 0; i < len; i++) {
        prefixPlates[i + 1] = prefixPlates[i] + (s[i] === '*' ? 1 : 0);
    }
    
    // Nearest candle to the left for each position
    const leftCandle = new Array(len).fill(-1);
    let lastCandle = -1;
    for (let i = 0; i < len; i++) {
        if (s[i] === '|') lastCandle = i;
        leftCandle[i] = lastCandle;
    }
    
    // Nearest candle to the right for each position
    const rightCandle = new Array(len).fill(-1);
    let nextCandle = -1;
    for (let i = len - 1; i >= 0; i--) {
        if (s[i] === '|') nextCandle = i;
        rightCandle[i] = nextCandle;
    }
    
    const answer = [];
    for (const [left, right] of queries) {
        const leftBound = rightCandle[left];   // first candle from left within query
        const rightBound = leftCandle[right];  // last candle from right within query
        
        if (leftBound !== -1 && rightBound !== -1 && leftBound < rightBound) {
            // Number of plates between candles = total plates minus plates outside
            const platesBetween = prefixPlates[rightBound + 1] - prefixPlates[leftBound + 1];
            answer.push(platesBetween);
        } else {
            answer.push(0);
        }
    }
    
    return answer;
};