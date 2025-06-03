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

        Map<Integer, int[]> map = new HashMap<>();
        Set<int[]> removed = new HashSet<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] problem = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            mxPq.offer(problem);
            mnPq.offer(problem);
            map.put(problem[0], problem);
        }


        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            String oper = inputs[0];
            
            if (oper.equals("recommend")) {
                int type = Integer.parseInt(inputs[1]);
                if (type == 1) {
                    while (removed.contains(mxPq.peek())) {
                        mxPq.poll();  
                    }
                    int[] target = mxPq.peek();
                    bw.write(String.valueOf(target[0]) + "\n");
                } else if (type == -1) {
                    while (removed.contains(mnPq.peek())) {
                        mnPq.poll();
                    }
                    int[] target = mnPq.peek();
                    bw.write(String.valueOf(target[0]) + "\n");
                }
            } else if (oper.equals("add")) {
                int probNum = Integer.parseInt(inputs[1]);
                int probLev = Integer.parseInt(inputs[2]);
                int[] problem = { probNum, probLev };
                mxPq.offer(problem);
                mnPq.offer(problem);
                map.put(problem[0], problem);
            } else if (oper.equals("solved")) {
                int probNum = Integer.parseInt(inputs[1]);
                int[] problem = map.get(probNum);
                map.remove(probNum);
                removed.add(problem);
            } 
        }
        bw.flush();
    }
}

/**
 * lazy 하게 처리하다보니 한 큐에 난이도가 다른 여러 개의 같은 넘버 문제가 있을 수 있다.
 */