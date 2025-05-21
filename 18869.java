import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int m = Integer.parseInt(inputs[0]);
        int n = Integer.parseInt(inputs[1]);

        int[][][] spaceFantasy = new int[m][n][2];
        for(int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < inputs.length; j++) {
                spaceFantasy[i][j][0] = Integer.parseInt(inputs[j]);
                spaceFantasy[i][j][1] = j;
            }
        }

        for (int i = 0; i < spaceFantasy.length; i++) {
            Arrays.sort(spaceFantasy[i], new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
        }

        int[] uniInfo = new int[105];
        for (int i = 0; i < 105; i++) {
            uniInfo[i] = i;
        }

        int ans = 0;
        for (int i = 0; i < spaceFantasy.length; i++) {
            int iRoot = unionFind(i, uniInfo);
            for (int j = i + 1; j < spaceFantasy.length; j++) {
                int jRoot = unionFind(j, uniInfo);
                if (iRoot == jRoot) {
                    ans++; 
                    continue;
                }
                if (isEval(spaceFantasy[i], spaceFantasy[j])) {
                    uniInfo[iRoot] = jRoot;
                    ans++;
                }
            }
        }

        bw.write("" + ans);
        bw.flush();
    }

    public static boolean isEval(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i][1] != b[i][1]) return false;
        }
        return true;
    }

    public static int unionFind(int i, int[] uniInfo) {
        if (uniInfo[i] == i) return i;
        return unionFind(uniInfo[i], uniInfo);
    }
}
/**
 * M 개 우주 있고 각 우주에는 N 개의 행성이 있다. 매트릭스
 * 균등한 우주가 몇쌍인지? 구성이 같은데 순서만 다른 우주의 쌍은 한 번만 (조합으로 해결한다?)\
 * 두 행성이 있을 때 각 우주의 모든 행성을 따졌을 때 
 * n^2 으로 다 따져야한다?
 * 
 * 2 <= ㅡ <= 100
 * 3 <= N <= 10,000
 * 
 * 100C2 * 10,000 ^ 2
 * 
 * 정렬 시 인덱스 순서가 같아야한다는 조건 같다.
 * 
 * 딱봐도 시간초과 그나마 개선해본다면 값으로 정렬 후 기존 인덱스 일치여부 따지기. 10000^2 으로 하나하나 비교하는거보다 훨 나은 방법
 * 100 * 10000 * lg10000 으로 세팅하면 된다. 이후 비교는 10000 으로 선형 탐색 하지만 우주쌍들이 10000 에 육박해서 여전히 시간초과발생
 * 유니온 파인드 같은 느낌으로 스킵시켜버릴까. 아하.. 유니온이 될 경우 개선이 되는데 그렇지 않다면 여전히 초과되겠구나..
 * 
 * 와 최대 100글자 문자열로 처리하라고..
 */