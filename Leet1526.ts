function minNumberOperations(target: number[]): number {
    let remains = target.reduce((acc, num) => acc + num, 0);

    let ans = 0;
    let val = target[0];
    ans += val;
    for (let i = 1; i < target.length; i++) {
        if (val < target[i]) {
            ans += target[i] - val;
        }
        val = target[i];
    }

    return ans;
};