class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);

        int n = set1.size();
        int[] output = new int[n];
        int index = 0;
        for (Integer i : set1) {
            output[index++] = i;
        }
        return output;
    }
}