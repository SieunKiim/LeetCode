import java.util.*;

public class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total += x;
        int rem = (int)(total % p);
        if (rem == 0) return 0;

        // prefix remainder → last seen index
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);  // 편의: prefix sum 0 at index -1

        int ans = nums.length;
        long prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int need = (int)((prefix - rem + p) % p);
            if (last.containsKey(need)) {
                ans = Math.min(ans, i - last.get(need));
            }
            // 항상 현재 prefix remainder 의 가장 최근 인덱스를 저장
            last.put((int)prefix, i);
        }

        return (ans == nums.length) ? -1 : ans;
    }
}
