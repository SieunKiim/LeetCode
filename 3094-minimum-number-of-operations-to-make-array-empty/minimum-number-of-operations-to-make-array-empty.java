class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            int count = map.getOrDefault(n,0);
            map.put(n, count + 1);
        }
        int output = 0;
        for(int val : map.values()){
            if (val == 1) return -1;
            if(val %3 == 0){
                output += val/3;
            } else {
                output += val/3 + 1;
            }
        }
        return output;
    }
}