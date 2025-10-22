import java.io.*;

class Main123 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) { // 50
            // 재귀 최대 깊이 5
            // 친구 한 명 고르고 다음 재귀 대상 지정에 최대 10
            // n의 5승
            String[] input = br.readLine().split(" ");
            int numOfStudents = Integer.parseInt(input[0]);
            int numOfFriendship = Integer.parseInt(input[1]);
            boolean[][] isFriend = new boolean[numOfStudents][numOfStudents];
            input = br.readLine().split(" ");
            if (numOfFriendship > 0) {
                for (int i = 0; i < input.length; i += 2) {
                    int one = Integer.parseInt(input[i]),  two = Integer.parseInt(input[i+1]);
                    isFriend[one][two] = true;
                    isFriend[two][one] = true;
                }
            }
            boolean[] isMatched = new boolean[numOfStudents];

            bw.write("" + rec(numOfStudents, isFriend, isMatched) + "\n");
            
        }
        bw.flush();
    }

    public static int rec(int numOfStudents, boolean[][] isFriend, boolean[] isMatched) {
        int curIdx = -1;
        for (int j = 0; j < numOfStudents; j++) {
            if (!isMatched[j]) {
                curIdx = j;
                break;
            }
        }
        if (curIdx == -1) return 1;
        isMatched[curIdx] = true;

        int ret = 0;
        for (int friendIdx = curIdx + 1; friendIdx < numOfStudents; friendIdx++) {
            if (isFriend[curIdx][friendIdx] && !isMatched[friendIdx]) {
                isMatched[friendIdx] = true;
                ret += rec(numOfStudents, isFriend, isMatched);
                isMatched[friendIdx] = false;
            }
        }
        isMatched[curIdx] = false;
        return ret;
    }
}