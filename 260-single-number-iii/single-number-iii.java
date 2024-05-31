class Solution {
    public int[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int[] output = new int[set.size()];
        int index = 0;
        for (Integer i : set) {
            output[index] = i;
            index += 1;
        }
        return output;
    }
}