import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long[] inputs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        long w = inputs[0];
        long h = inputs[1];
        long f = inputs[2];
        long c = inputs[3];
        long x1 = inputs[4];
        long y1 = inputs[5];
        long x2 = inputs[6];
        long y2 = inputs[7];

        long overlapX2 = f > w / 2 ? w - f : f;
        long overlapY2 = h;

        long cntRowOverlap = c + 1;
        long rowOverlapY = h / cntRowOverlap;

        long widthOverlap = 0;
        if (overlapX2 >= x1 && overlapX2 >= x2) {
            widthOverlap = (long)(x2 - x1) * (y2 - y1);
        } else if (overlapX2 > x1) {
            widthOverlap = (long)(overlapX2 - x1) * (y2 - y1);
        }

        long noOverlap = (y2 - y1) * (x2 - x1) - widthOverlap; // long 아님 오버플로우난다.
        long spreadCol = widthOverlap * 2 + noOverlap;
        long spreadRow = spreadCol * cntRowOverlap;
        System.out.println(w * h - spreadRow);
    }
}

/**
 * 세로로 접고 겹치는 부분 찾자 좌표 맨왼밑 맨오위로 압축
 * 가로로 접고.. 완전히 접는다는 보장있는듯 C+1 H 약수 이걸로 나누면 따떨어지고좌표 얻는다. 얼마나 접히는지도 알게 되고 이것도 곱해
 * 색칠한다. 좌표 두 개로 처리한 뒤. 세로접어 겹치는 부분만 따로 또 두 배 처리
 */