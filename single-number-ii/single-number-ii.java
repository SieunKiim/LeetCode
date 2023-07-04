class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            int temp = map.getOrDefault(num, 0)+1;
            if(temp == 1){
                set.add(num);
                map.put(num, temp);
            } else {
                set.remove(num);
            }
        }
        return set.iterator().next();
    }
}