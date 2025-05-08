import java.util.*;
import java.io.*;

public class Boj1911 {
public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        
        List<int[]> info = new ArrayList<>();
        while (n-- != 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info.add(new int[] {a, b});
        }

        Collections.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        // 반닫힘, 반열림 구간들을 인덱스와 합쳐 생각하려하니 복잡하다.
        // 반닫힘, 반열림 구간[)을  사용하기에 연속된 구간을 표현하기엔 좋았다.
        // 이 문제에선 웅덩이가 겹치지 않을뿐 연속되는 것은 가능하다.
        // 웅덩이의 설치가 시작되어야하는 곳을 idx 라 이름지었다.
        // 이미 설치가 된 곳이 아닌 설치가 시작되어야하는 곳이다.
        // 그렇기에 닫힌 구간과 열린 구간의 합으로 쉽게 표현이 가능했다.
        // idx += cost * l 를 보면 현재 위치에서 얼마나 바닥지를 붙여야하는지 구하는데
        // 구간의 특성을 고려해 현재 위치 idx 에서 바닥지 개수 * 바닥지 길이 를 더하면
        // 다음 바닥지를 붙이기 시작해야하는 위치를 구할 수 있었다.
        // 기억할 것은 반닫힘, 반열림 구간은 이 둘을 더함으로 그 다음 위치에서부터 접근이 가능하다는 것
        // 그리고 break, continue 가 발동된 조건문이다.
        // 바닥지를 붙이기 시작해야하는 위치가 마지막 웅덩이를 초과한다면 거기서 종료다.
        // 예를 들어 첫 웅덩이를 덮는데 바닥지가 10억까지 커버된다면 남은 웅덩이가 어찌되건 종료되는거다.
        // 그리고 바닥지를 붙이기 시작해야하는 위치와 실제 웅덩이가 있는 곳 간의 길이 차이가 난다면
        // 이 구간은 건너뛰어 (애초에 웅덩이가 없어 설치할 필요가 없다 그리디적인 요소) 웅덩이가 시작하는 곳부터 
        // 바닥지를 고려하면 된다.
        // 시간복잡도는 웅덩이 개수 N 일 때 O(N), 공간복잡도도 웅덩이 정보 저장의 O(N)
        int ans = 0;
        int idx = info.get(0)[0];
        int target = info.get(info.size() - 1)[1];
        for (int[] i : info) {
            if (idx >= target) break;
            int x1 = i[0], x2 = i[1];
            idx = Math.max(idx , x1);
            if (idx > x2 - 1) continue;
            int cur = x2 - idx;
            int cost = (int)(cur / l);
            if (cur % l != 0) cost += 1;
            ans += cost;
            idx += cost * l;
        }

        bw.write("" + ans);
        bw.flush();
    }
}
