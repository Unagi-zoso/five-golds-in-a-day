function findMinArrowShots(points: number[][]): number {
    points.sort((a: number[], b: number[]) => a[1] - b[1]);
    
    let recentLast = -Infinity;
    let answer = 0;

    for (let point of points) {
        const start = point[0];
        const last = point[1];

        if (!(start <= recentLast && recentLast <= last)) {
            answer++;
            recentLast = last;
        }        
    }

    return answer;
};