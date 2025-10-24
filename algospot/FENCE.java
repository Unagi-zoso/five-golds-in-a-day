import java.io.*;
import java.util.*;

class Main {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] fence = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // int ans = rec(fence, 0, fence.length);
            int ans = solve(fence);
            bw.write("" + ans + "\n");
        }
        bw.flush();
    }

    public static int solve(int[] fence) {
        int ret = 0;
        Stack<Integer> stk = new Stack<>();
        for (int curIdx = 0; curIdx < fence.length; curIdx++) {
            int curHeight = fence[curIdx];
            
            while (!stk.isEmpty() && fence[stk.peek()] > curHeight) {
                int prevIdx = stk.pop();
                int prevHeight = fence[prevIdx];
                int w = stk.isEmpty() ? curIdx : curIdx - stk.peek() - 1;
                ret = Math.max(ret, prevHeight * w);
            }

            stk.add(curIdx);
        }

        while (!stk.isEmpty()) {
            int prevIdx = stk.pop();
            int prevHeight = fence[prevIdx];
            int w = stk.isEmpty() ? fence.length : fence.length - stk.peek() - 1;
            ret = Math.max(ret, prevHeight * w);
        }

        return ret;
    }
    // public static int rec(int[] fence, int l, int r) {
    //     if (l + 1 == r) return fence[l];
    //     int mid = l + (r - l) / 2;

    //     int midToLeft = -1;
    //     int minHeightLeft = 1000000;
    //     for (int st = mid - 1; st >= l; st--) {
    //         minHeightLeft = Math.min(minHeightLeft, fence[st]);
    //         midToLeft = Math.max(midToLeft, minHeightLeft * (mid - st));
    //     }

    //     int midToRight = -1;
    //     int minHeightRight = 1000000;
    //     for (int st = mid; st < r; st++) {
    //         minHeightRight = Math.min(minHeightRight, fence[st]);
    //         midToRight = Math.max(midToRight, minHeightRight * (st - mid + 1));
    //     }

    //     int cl = mid - 1, cr = mid;
    //     int minHeightBoth = Math.min(fence[cl], fence[cr]);
    //     int bothvalue = minHeightBoth * 2;
    //     while (l < cl || cr < r-1) {
    //         boolean expandLeft;
    //         if (cl == l) {
    //             expandLeft = false;
    //         } else if (cr == r-1) {
    //             expandLeft = true;
    //         } else {
    //             expandLeft = fence[cl-1] >= fence[cr+1];
    //         }

    //         if (expandLeft) {
    //             minHeightBoth = Math.min(minHeightBoth, fence[--cl]);
    //         } else {
    //             minHeightBoth = Math.min(minHeightBoth, fence[++cr]);
    //         }

    //         bothvalue = Math.max(bothvalue, minHeightBoth * (cr - cl + 1));
    //     }

    //     return Math.max(midToLeft, 
    //         Math.max(midToRight,
    //         Math.max(bothvalue,
    //         Math.max(rec(fence, l, mid), rec(fence, mid, r))))
    //     );
    // }
}