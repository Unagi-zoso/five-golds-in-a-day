import java.io.*;
import java.util.*;
import java.util.stream.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		for (int i = 1; i <= n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(Integer.parseInt(st.nextToken()));
			temp.add(i);
			arr.add(temp);
		}
		
		Collections.sort(arr, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				if (a.get(0) != b.get(0)) return a.get(0) - b.get(0);
				return a.get(1) - b.get(1);
			}
		});
		
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).get(0) - i <= 0) {
				IntStream.rangeClosed(1, arr.size()).forEach(_i -> {System.out.print("" + _i + " ");});
				return;
			}
		}
		// String rst = String.join(" ", arr.stream().map(ar -> String.valueOf(ar.get(1))).collect(Collectors.toList()));
		// System.out.print(rst);
		arr.stream().forEach(ar -> {System.out.print("" + ar.get(1) + " ");});
	}
}
