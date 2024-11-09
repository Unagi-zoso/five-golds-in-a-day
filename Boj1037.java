import java.util.*;
import java.lang.*;
import java.io.*;

public class Boj1037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        List<Integer> nums = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(nums);

        bw.write("" + (nums.get(0) * nums.get(nums.size() - 1)));
        bw.flush();
    }
}
