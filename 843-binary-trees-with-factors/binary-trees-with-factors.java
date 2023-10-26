import java.util.*;

class Solution {
    
    public int numFactoredBinaryTrees(int[] arr) {
        int mod = 1000000007;
        Arrays.sort(arr);
        Set<Integer> s = new HashSet<>();
        for (int x : arr) s.add(x);

        Map<Integer, Integer> dp = new HashMap<>();
        for (int x : arr) dp.put(x, 1);

        for (int i : arr) {
            for (int j : arr) {
                if (j > Math.sqrt(i)) break;
                if (i % j == 0 && s.contains(i / j)) {
                    long temp = (long) dp.get(j) * dp.get(i / j);
                    dp.put(i, (int) ((dp.get(i) + (i / j == j ? temp : temp * 2)) % mod));
                }
            }
        }

        int result = 0;
        for (int val : dp.values()) {
            result = (result + val) % mod;
        }
        System.out.println(dp);
        return result;
    }
}