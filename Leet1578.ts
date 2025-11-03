function minCost(colors: string, neededTime: number[]): number {
    let mxCol = colors[0];
    let mxTime = neededTime[0];

    let time = 0;
    for (let i = 1; i < colors.length; i++) {
        if (colors[i] != mxCol) {
            mxCol = colors[i];
            mxTime = neededTime[i];
        } else {
            if (mxTime < neededTime[i]) {
                time += mxTime;
                mxTime = neededTime[i];
            } else {
                time += neededTime[i];
            }
        }
    }

    return time;
};