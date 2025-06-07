import java.util.*;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new Random().ints(100, 0, 1_000_000).toArray();

        sort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int st, int ed) {
        if (st + 1 == ed) {
            return;
        }
        int mid = st + (ed - st) / 2;
        sort(arr, st, mid);
        sort(arr, mid, ed);
        int i = 0;
        int j = 0;
        int idx = 0;
        int[] sorted = new int[arr.length];
        while (st + i < mid && mid + j < ed) {
            if (arr[st + i] <= arr[mid + j]) {
                sorted[idx++] = arr[st + i];
                i++;
            } else {
                sorted[idx++] = arr[mid + j];
                j++;
            }
        }
        while (st + i < mid) {
            sorted[idx++] = arr[st + i];
            i++;
        }
        while (mid + j < ed) {
            sorted[idx++] = arr[mid + j];
            j++;
        }

        for (int s = st; s < ed; s++) {
            arr[s] = sorted[s - st];
        }
    }
}