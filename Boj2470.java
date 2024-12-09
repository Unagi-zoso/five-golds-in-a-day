import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Boj2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        List<Integer> nums = Arrays.stream(strings).map(Integer::valueOf).collect(Collectors.toList());
        nums.sort(Integer::compareTo); // 오름차순 정렬

        int[] ans = {1000000001, 1000000001};

        for (int i = 0; i < nums.size() - 1; i++) {
            int target = -nums.get(i); // nums[i]와 합이 0에 가까운 값을 찾기 위해 반대값 설정
            int idx = binarySearch(nums, target, i + 1, nums.size() - 1);
            
            // idx가 범위 안에 있다면 비교하여 최적의 결과 갱신
            if (Math.abs(nums.get(i) + nums.get(idx)) < Math.abs(ans[0] + ans[1])) {
                ans[0] = nums.get(i);
                ans[1] = nums.get(idx);
            }
        }

        Arrays.sort(ans); // 결과를 오름차순 정렬
        System.out.println(ans[0] + " " + ans[1]);
    }

    public static int binarySearch(List<Integer> nums, int key, int start, int end) {
        int closestIndex = -1;
        int closestDiff = Integer.MAX_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = nums.get(mid);

            // 차이가 더 작다면 갱신
            int diff = Math.abs(key - midValue);
            if (diff < closestDiff) {
                closestDiff = diff;
                closestIndex = mid;
            }

            if (midValue < key) {
                start = mid + 1;
            } else if (midValue > key) {
                end = mid - 1;
            } else {
                return mid; // 정확히 같은 값을 찾음
            }
        }
        return closestIndex; // 가장 가까운 값의 인덱스 반환
    }
}