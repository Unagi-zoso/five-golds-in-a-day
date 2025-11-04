class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        TreeMap<Integer, TreeSet<Integer>> numFreqOrder = new TreeMap<>();
        Map<Integer, Integer> numFreq = new HashMap<>();

        for (int i = 0; i < k; i++) {
            int curFreq = numFreq.getOrDefault(nums[i], 0);
            numFreq.put(nums[i], curFreq + 1);
            if (numFreqOrder.containsKey(curFreq)) numFreqOrder.get(curFreq).remove(nums[i]);
            numFreqOrder.computeIfAbsent(curFreq + 1, (_k) -> new TreeSet(Comparator.reverseOrder())).add(nums[i]);
        }

        List<Integer> result = new ArrayList<>();
        result.add(0);
        Map.Entry<Integer, TreeSet<Integer>> lE = numFreqOrder.lastEntry();
        for (int i = 0; i < x;) {
            TreeSet<Integer> tS = lE.getValue();
            Iterator<Integer> it = tS.iterator();
            while(i < x && it.hasNext()) {
                result.set(result.size()-1, result.get(result.size()-1) + lE.getKey() * it.next());
                i++;
            }
            lE = numFreqOrder.lowerEntry(lE.getKey());
            if (lE == null) break;
            tS = lE.getValue();
        }
        
        for (int i = k; i < nums.length; i++) {
            int curFreq = numFreq.getOrDefault(nums[i], 0);
            numFreq.put(nums[i], curFreq + 1);
            if (numFreqOrder.containsKey(curFreq)) numFreqOrder.get(curFreq).remove(nums[i]);
            numFreqOrder.computeIfAbsent(curFreq + 1, (_k) -> new TreeSet(Comparator.reverseOrder())).add(nums[i]);
            int removeNum = nums[i-k];
            int rCurFreq = numFreq.getOrDefault(removeNum, 0);
            numFreq.put(removeNum, rCurFreq-1);

            numFreqOrder.get(rCurFreq).remove(removeNum);
            if (numFreqOrder.get(rCurFreq).isEmpty()) numFreqOrder.remove(rCurFreq);
            if (rCurFreq-1 != 0) {
                numFreqOrder.computeIfAbsent(rCurFreq-1, (_k) -> new TreeSet(Comparator.reverseOrder())).add(removeNum);
            }

            result.add(0);
            lE = numFreqOrder.lastEntry();
            for (int j = 0; j < x;) {
                TreeSet<Integer> tS = lE.getValue();
                Iterator<Integer> it = tS.iterator();
                while(j < x && it.hasNext()) {
                    result.set(result.size()-1, result.get(result.size()-1) + lE.getKey() * it.next());
                    j++;
                }
                lE = numFreqOrder.lowerEntry(lE.getKey());
                if (lE == null) break;
                tS = lE.getValue();
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}