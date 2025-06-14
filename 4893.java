import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int turn = 0;
        while (true) {
            turn++;
            char[] input = br.readLine().toCharArray();
            if (input[0] == '-') break;
            if (input.length <= 2 || check(input)) {
                bw.write(String.valueOf(turn) + ". 0");
                bw.newLine();
                continue;
            }

            int frogIdx = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == 'F') frogIdx = i;
            }

            int[] ans = { Integer.MAX_VALUE };
            rec(0, frogIdx, input, ans);
            if (ans[0] == Integer.MAX_VALUE) {
                bw.write(String.valueOf(turn) + ". -1");
            } else {
                bw.write(String.valueOf(turn) + ". " + String.valueOf(ans[0]));
            }
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        br.close();
    }

    public static void rec(int cur, int frogIdx, char[] tiles, int[] ans) {
        if (cur >= 10) {
            return;
        }

        if (frogIdx + 1 < tiles.length) {
            char temp = tiles[frogIdx + 1];
            tiles[frogIdx + 1] = tiles[frogIdx];
            tiles[frogIdx] = temp;
            if (check(tiles)) ans[0] = Math.min(ans[0], cur + 1);
            else rec(cur + 1, frogIdx + 1, tiles, ans);
            temp = tiles[frogIdx + 1];
            tiles[frogIdx + 1] = tiles[frogIdx];
            tiles[frogIdx] = temp;
        }
        if (frogIdx - 1 >= 0) {
            char temp = tiles[frogIdx - 1];
            tiles[frogIdx - 1] = tiles[frogIdx];
            tiles[frogIdx] = temp;
            if (check(tiles)) ans[0] = Math.min(ans[0], cur + 1);
            else rec(cur + 1, frogIdx - 1, tiles, ans);
            temp = tiles[frogIdx - 1];
            tiles[frogIdx - 1] = tiles[frogIdx];
            tiles[frogIdx] = temp;
        }
        if (frogIdx + 2 < tiles.length) {
            char temp = tiles[frogIdx + 2] == 'W' ? 'B' : 'W';
            tiles[frogIdx + 2] = tiles[frogIdx];
            tiles[frogIdx] = temp;
            if (check(tiles)) ans[0] = Math.min(ans[0], cur + 1);
            else rec(cur + 1, frogIdx + 2, tiles, ans);
            temp = tiles[frogIdx + 2];
            tiles[frogIdx + 2] = tiles[frogIdx]  == 'W' ? 'B' : 'W';
            tiles[frogIdx] = temp;
        }
        if (frogIdx - 2 >= 0) {
            char temp = tiles[frogIdx - 2] == 'W' ? 'B' : 'W';
            tiles[frogIdx - 2] = tiles[frogIdx];
            tiles[frogIdx] = temp;
            if (check(tiles)) ans[0] = Math.min(ans[0], cur + 1);
            else rec(cur + 1, frogIdx - 2, tiles, ans);
            temp = tiles[frogIdx - 2];
            tiles[frogIdx - 2] = tiles[frogIdx]  == 'W' ? 'B' : 'W';
            tiles[frogIdx] = temp;
        }
    }

    public static boolean check(char[] tiles) {
        boolean firstBlack = false;
        boolean whiteAfterFirstBlack = false;

        for (int i = 0; i < tiles.length; i++) {
            if (tiles[i] == 'B' && !firstBlack) firstBlack = true;
            else if (tiles[i] == 'W' && firstBlack && !whiteAfterFirstBlack) whiteAfterFirstBlack = true;
            else if (tiles[i] == 'B' && whiteAfterFirstBlack) return false;
        }
        return true;
    }
}

/*
 * 걷거나 뛸 수 있는 개구리 존재. 앞 뒤로 갈 수 있다.
 * 타일은 흑백으로 존재.
 * 개구리는 인접한 타일에만 앞뒤로 걷기 가능.
 * 워크하면 그 방향 타일이랑 치환
 * 뛰기도 가능한데 이때도 타일 치환
 * 
 *
 * 목적은 브랙 타일 사이에 화이트 타일이 없도록 만들기
 * 최소 동작으로 한 타일 설정을 다른걸로 바꿔라
 * 10도작 안에 못하면 -1 출력
 */