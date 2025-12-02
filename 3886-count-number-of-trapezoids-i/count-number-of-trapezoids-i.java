class Solution {

    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        final int mod = 1000000007;
        long ans = 0;
        long sum = 0;
        for(int[] point :points){
            map.put(point[1], map.getOrDefault(point[1], 0)+1);
        }
        for(int num : map.values()){
            int temp  = (int)(((long) num * (num-1) / 2 )%mod);
            ans =  (ans + (sum * temp) % mod) % mod;
            sum = (sum + temp) % mod; 
        }
        return (int) ans%mod;
    }
}