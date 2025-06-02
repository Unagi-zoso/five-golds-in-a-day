import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] nums1 = new int[41];
        int[] nums2 = new int[41];
        Arrays.fill(nums1, -1);
        Arrays.fill(nums2, -1);
        int num1MX = -1;
        int num2MX = -1;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            if (nums1[num] == -1) {
                nums1[num] = i;
                num1MX = Math.max(num1MX, num);
            }
            else if (nums2[num] == -1) {
                nums2[num] = i;
                num2MX = Math.max(num2MX, num);
            }
            else {
                bw.write(String.valueOf(ans));
                bw.flush();
                return;
            }
        }

        for (int i = 0; i < num1MX; i++) {
            if (nums1[i] == -1) {
                bw.write(String.valueOf(ans));
                bw.flush();
                return;
            }
        }

        for (int i = 0; i < num2MX; i++) {
            if (nums2[i] == -1) {
                bw.write(String.valueOf(ans));
                bw.flush();
                return;
            }
        }

        int lowestExponent = Math.min(num1MX, num2MX) + 1;
        ans = num2MX == -1 ? 2 : (int)Math.pow(2, lowestExponent) * (num1MX == num2MX ? 1 : 2);

        bw.write(String.valueOf(ans));
        bw.flush();
    }
}