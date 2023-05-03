class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> output = new ArrayList<>();
        Set<Integer> arr1 = new HashSet<>();
        Set<Integer> arr2 = new HashSet<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int num : nums1){
            set1.add(num);
        }
        for(int num:nums2){
            set2.add(num);
        }

        for(int num : nums1){
            if(!set2.contains(num)) arr1.add(num);
        }
        for(int num:nums2){
            if(!set1.contains(num)) arr2.add(num);
        }
        output.add(new ArrayList<>(arr1));
        output.add(new ArrayList<>(arr2));
        return output;
    }
}