class Solution {
    public String gcdOfStrings(String str1, String str2) {
        return (str1 + str2).equals(str2 + str1) ? str1.substring(0, gcd(str1.length(), str2.length())) : "";
    }

    public int gcd(int lhs, int rhs) {
        return lhs % rhs == 0 ? rhs : gcd(rhs, lhs % rhs);
    }
}

/*
 * 반복만으로 전체 문장을 구성할 수 있는 최대 크기의 부분 문자를 구하라
 * 추가적으로 두 문자열이 주어지고 이 두 문자열에서 공통적인 최대 크기의 부분 문자열를 구해야합니다.
 * 
 * 구성요소가 같다면 str1 + str2, str2 + str1 을 비교하면 같을 수 밖에 없습니다.
 * 공통 부분 문자열들로 서로 구성되어있으면 참이 됩니다.
 * 
 * 그리고 이 부분 문자열의 최대 길이는 두 문자열의 최대공약수와 같습니다.
 */
