import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<int[]> mxPq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
                return Integer.compare(b[0], a[0]);
            }
        });

        PriorityQueue<int[]> mnPq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            }
        });

        Map<Integer, int[]> hashMapForRemove = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] problem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            hashMapForRemove.put(problem[0], problem);
            mxPq.offer(problem);
            mnPq.offer(problem);
        }


        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            String oper = inputs[0];
            
            if (oper.equals("recommend")) {
                int type = Integer.parseInt(inputs[1]);
                if (type == 1) {
                    int[] target = mxPq.peek();
                    bw.write(String.valueOf(target[0]) + "\n");
                } else if (type == -1) {
                    int[] target = mnPq.peek();
                    bw.write(String.valueOf(target[0]) + "\n");
                }
            } else if (oper.equals("add")) {
                int probNum = Integer.parseInt(inputs[1]);
                int probLev = Integer.parseInt(inputs[2]);
                int[] problem = { probNum, probLev };
                mxPq.offer(problem);
                mnPq.offer(problem);
                hashMapForRemove.put(problem[0], problem);
            } else if (oper.equals("solved")) {
                int probNum = Integer.parseInt(inputs[1]);
                int[] target = hashMapForRemove.get(probNum);
                mxPq.remove(target);
                mnPq.remove(target);
                hashMapForRemove.remove(target);
            } 
        }
        bw.flush();
    }
}