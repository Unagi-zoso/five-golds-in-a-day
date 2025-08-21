class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], 
                                    Math.min(dp[i-1][j], dp[i-1][j-1])
                                );
                }
            }
        }
        return dp[l1][l2];
    }
}

/**
 * i, j 지향 시
 * i-1, j-1 은 j-1까지는 i-1 만으로 보장 가능함. i,j 번째만 맞추면 되기에 치환
 * i, j-1 은 i로도 처리할 수 있는 j-1까지. 즉 하나를 더 더해야만 한다. 삽입
 * i-1, j 은 i-1으로 충분히 j를 다 표현함. i 번째는 사족이니 제거.
 * 이걸 어떻게 떠올려..
 */

/**
 * First try
 * class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 1; i <= l1; i++){
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        List<Integer> li1 = new ArrayList<>();
        List<Integer> li2 = new ArrayList<>();
        int y = l1, x = l2;
        int ans = dp[y][x];
        int start = dp[y][x];
        // StringBuilder sb = new StringBuilder();
        while (start > 0 && y >= 1 && x >= 1) {
            if (dp[y-1][x] == start) {
                y--;
            } else if (dp[y][x-1] == start) {
                x--;
            } else {
                li1.add(y-1);
                li2.add(x-1);
                // sb.append(word1.charAt(y-1));
                start = dp[--y][--x];
            }
        }
        // System.out.println(sb.reverse().toString());
        li1.reversed();
        li2.reversed();
        for (int i = 0; i < li1.size()-1; i++) {
            int g1 = li1.get(i+1) - li1.get(i);
            int g2 = li2.get(i+1) - li2.get(i);
            // System.out.println("li1: " + li1.get(i+1) + " " + li1.get(i) + "  li2: " + li2.get(i+1) + " " + li2.get(i) + " " + g1 + " " + g2);
            if (Math.abs(g2-g1) < 2) continue;
            ans += Math.abs(g2-g1);
        }
        return l1-ans;
    }
}

/**
s1 을 s2로 만드는데 드는 최소한의 연산 수
연산 종류
삽입(기존꺼 밀림), 제거(뒤에꺼 당겨짐), 치환(삽입, 제거를 동시에 해주는 착한 아이?)
꽤 복잡하고 그리디한 전략은 사실상 힘들듯. 브루트포스도 감이 안 올 지경.
LCS 만큼 뺀거가 힌트일까. 당겨짐과 밀어짐에 의해 엄청 효율적여지는 구간이 생기진 않을까.. 아닌가. LCS면 괜찮나..
LCS를 구해서 밀려난다. 당겨낸다 했을떄도 최적일 수 있나?


exception

tion

당긴다해도 이득인듯하다.. LCS 개수는 무조건 이득?!
LCS 위치 맞춰주기 비용.
각 글자별 간격 쁠마.
사이 간격을 동일하게 ..

동일한 문자 있으면 다 뭍혀버린다.
lcs가 앞에서부터 진행하다보니 앞에 있는걸 먼저 선택하고
또 .. 그래도 분포가 좁은게 유리할거 같은데.
 */