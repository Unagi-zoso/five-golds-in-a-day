import java.util.*;
import java.lang.*;
import java.io.*;

public class Boj1181 {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        Set<String> set = new HashSet<>();

        List<String> unqList = new ArrayList<>();
        for (String word : words) {
            if (set.add(word)) {
                unqList.add(word);
            }
        }

        Collections.sort(unqList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for (String word : unqList) {
            System.out.println(word);
        }
    }
}
