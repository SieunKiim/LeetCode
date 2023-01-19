class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        map.put(0,1);
        for(int n : nums){
            sum = (sum + n) % k;
            if(sum < 0) sum += k;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}