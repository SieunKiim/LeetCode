public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        // Step 1: 전체 gcd 확인
        int overallGcd = nums[0];
        for (int num : nums) {
            overallGcd = gcd(overallGcd, num);
        }
        if (overallGcd != 1) return -1;

        // Step 2: 이미 1이 있는 경우
        int ones = 0;
        for (int num : nums) {
            if (num == 1) ones++;
        }
        if (ones > 0) return n - ones;

        // Step 3: 구간 중 gcd가 1이 되는 최소 길이 찾기
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        // 결과 계산
        return (minLen - 1) + (n - 1);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
