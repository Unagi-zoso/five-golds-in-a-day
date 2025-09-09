function eraseOverlapIntervals(intervals: number[][]): number {
    intervals.sort((a: number[], b: number[]) => a[1] - b[1]);
    
    let answer = 0;
    let curEnd = -Infinity;
    for (let interval of intervals) {
        const start = interval[0];
        const end = interval[1];
        if (curEnd <= start) curEnd = end;
        else answer++;
    }
    return answer;
};