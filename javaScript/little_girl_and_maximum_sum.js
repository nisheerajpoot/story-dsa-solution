process.stdin.resume();
process.stdin.setEncoding('utf-8');

let input = '';
process.stdin.on('data', function(chunk) {
    input += chunk;
});

process.stdin.on('end', function() {
    const lines = input.trim().split('\n');
    let idx = 0;
    
    // Read n and q
    const [n, q] = lines[idx++].split(' ').map(Number);
    
    // Read array
    const a = lines[idx++].split(' ').map(Number);
    
    // Difference array
    const c = new Array(n + 2).fill(0);
    
    // Process queries
    for (let i = 0; i < q; i++) {
        let [l, r] = lines[idx++].split(' ').map(Number);
        c[l - 1]++;
        c[r]--;
    }
    
    // Prefix sum to get frequencies
    for (let i = 1; i < n; i++) {
        c[i] += c[i - 1];
    }
    
    // Sort both arrays
    a.sort((x, y) => x - y);
    const freq = c.slice(0, n).sort((x, y) => x - y);
    
    // Calculate maximum sum
    let answer = 0;
    for (let i = 0; i < n; i++) {
        answer += a[i] * freq[i];
    }
    
    console.log(answer);
});