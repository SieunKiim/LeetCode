class Solution {
    public int repeatedNTimes(int[] nums) {
        int output = 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            } else {
                set.add(num);
            }
        }
        return output;
    }
}