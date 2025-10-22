import java.io.*;
import java.util.*;

class BOGGLE {
    public static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int C = Integer.parseInt(br.readLine());
        while (C-- > 0) {
            char[][] board = new char[5][5];
            for (int i = 0; i < 5; i++) {
                board[i] = br.readLine().toCharArray();
            }

            int N = Integer.parseInt(br.readLine());

            // 문자 하나마다 bfs로 구하기
            // bfs 는 전체 보드 순회하며 시작 노드 찾고 q 안에 넣기.
            // 매번 순회해서 바운더리 따지는게 애매하다. 이중 해시로 처리
            // 하나 선택. 주변 부 해시에 추가. 찾는 다음 문자 서치. 없으면 끝. 있으면 이어서.
            // 재귀로 풀어야하나. 찾아야하는건 반복해서 그 다음꺼 찾을땐 재귀로 넘기기
            for (int i = 0; i < N; i++) {
                String target = br.readLine();
                boolean result = solve(board, target.toCharArray());
                bw.write(target + " " + (result ? "YES" : "NO") + "\n");
            }
        }
        bw.flush();
    }

    public static boolean solve(char[][] board, char[] target) {
        Map<Character, Set<int[]>> movable = new HashMap<>(); // set 중복검사 귀찮고 순차조회필요. 해시, 연결리스 둘 다 연속x
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == target[0]) {
                    int[] start = new int[] {i, j};
                    movable.computeIfAbsent(target[0], (k) -> new HashSet<>())
                    .add(start);
                    if (rec(board, movable, visited, target, 0)) return true;
                    movable.get(target[0]).remove(start);
                }
            }
        }
        return false;
    }

    public static boolean rec(char[][] board, Map<Character, Set<int[]>> movable, Set<String> visited, char[] target, int tIdx) {
        if (tIdx >= target.length) return true;
        for (int[] cur : movable.getOrDefault(target[tIdx], new HashSet<>())) { // Exception in thread "main" java.util.ConcurrentModificationException
            int y = cur[0], x = cur[1];
            String visitedKey = y + " " + x;
            if (visited.contains(visitedKey)) continue;
            visited.add(visitedKey);
            for (int[] d : dir) {
                int ny = y + d[0], nx = x + d[1];
                if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) continue;
                int[] next = new int[] {ny, nx};
                movable.computeIfAbsent(target[0], (k) -> new HashSet<>())
                .add(next);
            }

            if (rec(board, movable, visited, target, tIdx+1)) return true;
            
            for (int[] d : dir) {
                int ny = y + d[0], nx = x + d[1];
                if (ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) continue;
                int[] next = new int[] {ny, nx};
                movable.get(target[0]).remove(next);
            }
            visited.remove(visitedKey);
        }
        return false;
    }
}