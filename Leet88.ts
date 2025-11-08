/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
    let n1P = n;

    for (let i = m+n-1; i >= n; i--) {
        if(i-n >= 0) {
            nums1[i] = nums1[i-n];
        }
    }
    let n2P = 0;
    let n1Var = -9000000000;
    let n2Var = -9000000000;
    let newIdx = 0;
    while ((n1P < m+n || n1Var != -9000000000) && (n2P < n || n2Var != -9000000000)) {
        n1Var = n1Var === -9000000000 ? nums1[n1P++] : n1Var;
        n2Var = n2Var === -9000000000 ? nums2[n2P++] : n2Var;
        if (n1Var <= n2Var) {
            nums1[newIdx++] = n1Var;
            n1Var = -9000000000;
        } else {
            nums1[newIdx++] = n2Var;
            n2Var = -9000000000;
        }
    }
    while(n1Var != -9000000000 || n1P < m+n) {
        n1Var = n1Var === -9000000000 ? nums1[n1P++] : n1Var;
        nums1[newIdx++] = n1Var;
        n1Var = -9000000000;
    }

    while(n2Var != -9000000000 || n2P < n) {
        n2Var = n2Var === -9000000000 ? nums2[n2P++] : n2Var;
        nums1[newIdx++] = n2Var;
        n2Var = -9000000000;
    }
};
