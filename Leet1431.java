import java.util.*;
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandy = Math.max(candy, maxCandy);
        }
        List<Boolean> rslt = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            rslt.add(candies[i] + extraCandies >= maxCandy);
        }
        return rslt;
    }
}

/*
return Arrays.stream(candies)
                .mapToObj(candy -> candy + extraCandies >= maxCandy)
                .toList();
*/