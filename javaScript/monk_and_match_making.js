process.stdin.resume();
process.stdin.setEncoding('utf-8');

let input = '';
process.stdin.on('data', function(chunk) {
    input += chunk;
});

process.stdin.on('end', function() {
    const lines = input.trim().split('\n');
    let idx = 0;
    
    // Read the string
    const s = lines[idx++];
    const n = s.length;
    
    // Base and modulus for rolling hash
    const base = 911382323n;
    const mod = 1000000007n;
    
    // Precompute powers
    const powArr = new Array(n + 2);
    powArr[0] = 1n;
    for (let i = 1; i <= n; i++) {
        powArr[i] = (powArr[i - 1] * base) % mod;
    }
    
    // Compute prefix hashes
    const hashArr = new Array(n + 2);
    hashArr[0] = 0n;
    for (let i = 0; i < n; i++) {
        const val = BigInt(s.charCodeAt(i) - 96);
        hashArr[i + 1] = (hashArr[i] * base + val) % mod;
    }
    
    // Read number of queries
    const q = parseInt(lines[idx++]);
    
    // Process each query
    const output = [];
    for (let i = 0; i < q; i++) {
        const [L1, R1, L2, R2] = lines[idx++].split(' ').map(Number);
        
        // Check if lengths are different
        if ((R1 - L1) !== (R2 - L2)) {
            output.push("No");
            continue;
        }
        
        // Calculate hash for first substring
        let h1 = (hashArr[R1] - (hashArr[L1 - 1] * powArr[R1 - L1 + 1]) % mod + mod) % mod;
        
        // Calculate hash for second substring
        let h2 = (hashArr[R2] - (hashArr[L2 - 1] * powArr[R2 - L2 + 1]) % mod + mod) % mod;
        
        if (h1 === h2) {
            output.push("Yes");
        } else {
            output.push("No");
        }
    }
    
    console.log(output.join('\n'));
});