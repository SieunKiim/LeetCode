import java.util.*;

class Solution {
    public double new21Game(int n, int k, int maxPts) {
        // 특수 케이스 1: k == 0 → 게임 시작하자마자 멈춤 → 점수 0이 항상 n 이하
        if (k == 0) return 1.0;
        // 특수 케이스 2: n >= k - 1 + maxPts → 가능한 모든 최종 점수가 n 이하
        if (n >= k - 1 + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double W = 1.0; // 처음엔 dp[0] 하나만 윈도우에 있음
        double result = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = W / maxPts;

            if (i < k) {
                // 아직 k 미만 → 다음 상태 만들 수 있음 → W에 추가
                W += dp[i];
            } else {
                // i >= k → 게임이 종료되는 상태 → 최종 답에 더해줌
                result += dp[i];
            }

            // 창(window)에서 벗어난 dp 제거
            if (i - maxPts >= 0) {
                W -= dp[i - maxPts];
            }
        }

        return result;
    }
}