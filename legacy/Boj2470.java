import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Boj2470 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");
        List<Integer> nums = Arrays.stream(strings).map(str -> Integer.valueOf(str)).collect(Collectors.toList());
        nums.sort(new Comparator<Integer>() { 
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });

        List<Integer> ans = Arrays.asList(1000000001, 1000000001);
        for (int i = 0; i < nums.size() - 1; i++) { // 원소 하나 남았을 땐 생각 안해도 된다.
            int idx = bs(nums, -(nums.get(i)), i + 1, nums.size() - 1);
            if (Math.abs(nums.get(i) + nums.get(idx)) < Math.abs(ans.get(0) + ans.get(1))) {
                ans.set(0, nums.get(i));
                ans.set(1, nums.get(idx));
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("" + ans.get(0) + " " + ans.get(1));
        bw.flush();
    }
    
    public static int bs(List<Integer> nums , int key, int st, int lst) {
        int result = (st + lst) >>> 1;
        while (st <= lst) {
            int mid = (st + lst) >>> 1;
            if (Math.abs(nums.get(mid) - key) < Math.abs(nums.get(result) - key) ) {
                result = mid;
            }
            if (nums.get(mid) < key) st = mid + 1;
            else if (nums.get(mid) > key) lst = mid - 1;
            else return mid;
        }
        return result;
    }
}

// System.out.println("" + (5 >>> 2));
//         System.out.println("" + (-5 >>> 2));
//         LinkedList<Integer> i = new LinkedList<>();
//         Set<Integer> s = new HashSet<>();
//         s.add(1);
//         s.add(2);
//         s.add(3);
//         i.offer(1);
//         i.offer(2);
//         i.offer(3);
//         System.out.println(Collections.binarySearch(i, 3));
//         System.out.println(Collections.binarySearch(i, 4));
//     }

// 1 2 3 4 7 9 10
// - 9 1 2 3 4 100000
// public class Boj2470 {
//     public static void main(String[] args) throws Exception {
//         //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         // int n = Integer.parseInt(br.readLine());
//         // String[] strings = br.readLine().split(" ");
//         String[] strings = { "1", "2", "3", "5", "6", "9" };
//         List<Integer> nums = Arrays.stream(strings).map(str -> Integer.valueOf(str)).collect(Collectors.toList());
//         nums.sort(new Comparator<Integer>() { 
//             @Override
//             public int compare(Integer a, Integer b) {
//                 return a - b;
//             }
//         });

//         int ans = bs(nums, 7, 0, nums.size()-1);

//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         bw.write("" + ans);
//         bw.flush();
//     }
    
//     public static int bs(List<Integer> nums , int key, int st, int lst) {
//         while (st <= lst) {
//             int mid = (st + lst) / 2; // 캐스팅 되나 몰라
//             if (nums.get(mid) < key) st = mid + 1;
//             else if (nums.get(mid) > key) lst = mid - 1;
//             else return mid;
//         }
//         return st;
//     }
// }