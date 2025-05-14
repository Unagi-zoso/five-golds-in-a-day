import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numOfGear = 4;
        List<LinkedList<Integer>> gears = new ArrayList<>();

        for (int i = 0; i < numOfGear; i++) {
            LinkedList<Integer> gear = new LinkedList<>();
            String input = br.readLine();
            for (int j = 0; j < input.length(); j++) {
                gear.addLast(Integer.parseInt(Character.toString(input.charAt(j))));
            }
            gears.add(gear);
        }

        int numOfOper = Integer.parseInt(br.readLine());
        for (int i = 0; i < numOfOper; i++) {
            String[] inputs = br.readLine().split(" ");
            int gearId = Integer.parseInt(inputs[0]) - 1;
            int dir = Integer.parseInt(inputs[1]);
            boolean[] visited = new boolean[4];

            rollingRec(gears, visited, gearId, dir);
        }

        int ans = 0;
        for (int i = 0; i < numOfGear; i++) {
            LinkedList<Integer> curGear = gears.get(i);
            if (curGear.get(0) == 1) ans += Math.pow(2, i);
        }

        bw.write("" + ans);
        bw.flush();
    }

    public static void rollingRec(List<LinkedList<Integer>> gears, boolean[] visited, int gearId, int dir) {
        if (visited[gearId]) return;
        visited[gearId] = true;

        int prevGearId = gearId - 1;
        if (prevGearId >= 0 && gears.get(prevGearId).get(2) != gears.get(gearId).get(6)) {
            rollingRec(gears, visited, prevGearId, dir * -1);
        }

        int nextGearId = gearId + 1;
        if (nextGearId < gears.size() && gears.get(nextGearId).get(6) != gears.get(gearId).get(2)) {
            rollingRec(gears, visited, nextGearId, dir * -1);
        }

        rolling(gears, gearId, dir);
    }

    public static void rolling(List<LinkedList<Integer>> gears, int gearId, int dir) {
        LinkedList<Integer> curGear = gears.get(gearId);
        if (dir == 1) {
            int last = curGear.pollLast();
            curGear.addFirst(last);
        } else if (dir == -1) {
            int first = curGear.pollFirst();
            curGear.addLast(first);
        }
    }
}
/*
 * pop 아니야 poll 이야
 * 근데 offer 말고 add 인건 뭐지.. offerLast, offerFirst 도 있나?
 */