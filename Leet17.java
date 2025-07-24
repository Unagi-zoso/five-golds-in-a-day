class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        List<List<Character>> chtb = List.of(
            List.of('a', 'b', 'c'),
            List.of('d', 'e', 'f'),
            List.of('g', 'h', 'i'),
            List.of('j', 'k', 'l'),
            List.of('m', 'n', 'o'),
            List.of('p', 'q', 'r', 's'),
            List.of('t', 'u', 'v'),
            List.of('w', 'x', 'y', 'z')
        );

        rec(digits, 0, chtb, new StringBuilder(), ans);
        return ans;
    }

    void rec(String digits, int lev, List<List<Character>> chtb, StringBuilder temp, List<String> ans) {
        if (lev == digits.length()) {
            if (temp.length() != 0) ans.add(temp.toString());
            return;
        }
        for (char ch : chtb.get(digits.charAt(lev)-'2')) {
            temp.append(ch);
            rec(digits, lev+1, chtb, temp, ans);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    // StringBuilder 잘 다루기가 헷갈
    // deleteCharAt 으로 제거 가능
}