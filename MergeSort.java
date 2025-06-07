import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new Random().ints(10, 0, 1_000).toArray();
        System.out.println(Arrays.toString(arr));
        
        int[] sorted = sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(sorted));
    }

    public static int[] sort(int[] arr, int st, int ed) {
        if (st + 1 == ed) {
            int[] newArr = {arr[st]};
            return newArr;
        }
        int mid = st + (ed - st) / 2;
        int[] lhs = sort(arr, st, mid);
        int[] rhs = sort(arr, mid, ed);

        int lIdx = 0;
        int rIdx = 0;
        int sIdx = 0;
        int[] sorted = new int[lhs.length + rhs.length];
        while (lIdx < lhs.length && rIdx < rhs.length) {
            if (lhs[lIdx] <= rhs[rIdx]) {
                sorted[sIdx++] = lhs[lIdx++];
            } else {
                sorted[sIdx++] = rhs[rIdx++];
            }
        }
        while (lIdx < lhs.length) {
            sorted[sIdx++] = lhs[lIdx++];
        }
        while (rIdx < rhs.length) {
            sorted[sIdx++] = rhs[rIdx++];
        }
        return sorted;
    }
}