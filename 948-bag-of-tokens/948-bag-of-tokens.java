// 4:12 pm 시작
// 
//
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
       Arrays.sort(tokens);
        int life = 0;
        int start = 0, end = tokens.length-1;
        int result = 0;
        while (start <= end) {
            if (power >= tokens[start]) {
                power -= tokens[start];
                start += 1;
                life += 1;
                result = Math.max(result, life);
            } else if (life > 0) {
                life -= 1;
                power += tokens[end];
                end -= 1;
            } else break;
        }
        return result; 
    }
}