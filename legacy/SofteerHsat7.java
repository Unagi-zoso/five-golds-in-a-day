import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SofteerHsat7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sT = new StringTokenizer(bR.readLine());
        int n = Integer.parseInt(sT.nextToken());
        int q = Integer.parseInt(sT.nextToken());
        
        sT = new StringTokenizer(bR.readLine());
        int[] nums = new int[n];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(sT.nextToken());
        }

        Arrays.sort(nums);

        for(int i = 0; i < q; i++) {
            int _q = Integer.parseInt(bR.readLine());
            int left = binarySearchLeft(nums, _q);

            if (left < 0) {
                bW.write(0 + "\n");
                continue;
            }

            int right = nums.length - binarySearchRight(nums, _q) - 1;
            bW.write(left * right + "\n");
        }

        bW.flush();
        bR.close();
        bW.close();
    }

    private static int binarySearchLeft(int[] nums, int key) {
        int idx = Arrays.binarySearch(nums, key);

        if (idx < 0) {
            return idx;
        } else {
            while (idx > 0 && nums[idx - 1] == key) {
                idx--;
            }
            return idx;
        }
    }

    private static int binarySearchRight(int[] nums, int key) {
        int idx = Arrays.binarySearch(nums, key);

        if (idx < 0) {
            return idx;
        } else {
            while (idx < nums.length - 1 && nums[idx + 1] == key) {
                idx++;
            }
            return idx;
        }
    }
}