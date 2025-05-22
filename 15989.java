import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[10000+1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= 10000; i++) {
            dp[i] += 1;
            dp[i] += dp[i-2] - dp[i-5];
            dp[i] += dp[i-3];
        }

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            // System.out.println("" + dp[n-1] + " " + dp[n]);
            bw.write(String.valueOf(dp[n]) + "\n");
            bw.flush();
        }
    }
}

/*
 * 1,2,3 으로 4를 나타내라. 반드시 하나 이상 써야하고. 순서는 영향 없다. 조합
 * n 이 주어질때 1,2,3 으로 나타낼 수 있는 경우의 수
 * 
 * 1 : 1
 * 2 : (1,1) , (2)
 * 3 : (1,1,1), (2, 1), 3
 * 4 : (1111), (211), (22), (31)
 * 5 : (11111) (1112) (122) (113) (2 3)
 * 6 : (111111) (11112) (1122) (222) (1113) (33) (132) ()
 * 
 * 이거만 봤을땐 순회로 가능할거 같은데 중복 자르기가 핵심?
 * i - 1, -2, -3
 * 
 * 1을 붙여서 해결한 개수.. 따로 관리
 * 
 * 원소들끼리 순서가 중요하지 않은 문제는 정렬개념으로 접근하는게 중요하다.
 * 이전 데이터에서 1을 추가한다했을때 이전 데이터는 1보다 작거나 같은 구성으로된 데이터만 다뤄야한다.
 * 두드러지는 부분은 2를 추가하는 경우인데 2를 추가하려면 이전 데이터에선 2보다 큰 3이 섞인 데이터들은 걸러내야한다.
 * 그 개수는 i - 2 의 3이 포함된 데이터의 개수 즉 dp[i - 5] 값이다.
 */