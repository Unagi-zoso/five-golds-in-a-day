function lexicalOrder(n: number): number[] {
    const result = [];
    for (let i = 1; i <= 9; i++) {
        if (i > n) break;
        result.push(i);
        rec(n, i, result);
    }
    return result;
};


function rec(n: number, cur: number, result: number[]): void {
    if (cur * 10 > n) return;

    for (let i = 0; i <= 9; i++) {
        if (cur * 10 + i > n) return;
        result.push(cur * 10 + i);
        rec(n, cur * 10 + i, result);
    }
};