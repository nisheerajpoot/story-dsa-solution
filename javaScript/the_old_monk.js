process.stdin.resume();
process.stdin.setEncoding("utf-8");
var stdin_input = "";

process.stdin.on("data", function (input) {
    stdin_input += input;
});

process.stdin.on("end", function () {
    main(stdin_input);
});

function main(input) {
    const lines = input.trim().split("\n");
    let idx = 0;
    
    // Read number of test cases
    const tc = parseInt(lines[idx++]);
    
    let results = [];
    
    for (let t = 0; t < tc; t++) {
        // Read size of arrays
        const n = parseInt(lines[idx++]);
        
        // Read array A
        const A = lines[idx++].split(" ").map(Number);
        
        // Read array B
        const B = lines[idx++].split(" ").map(Number);
        
        // Two pointer approach
        let i = 0;
        let j = 0;
        let maxMonkiness = 0;
        
        while (i < n && j < n) {
            if (B[j] >= A[i]) {
                maxMonkiness = Math.max(maxMonkiness, j - i);
                j++;
            } else {
                i++;
            }
        }
        
        results.push(maxMonkiness);
    }
    
    // Output all results
    process.stdout.write(results.join("\n") + "\n");
}