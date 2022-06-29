class Solution {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        ArrayList<Integer> diffArr = new ArrayList<>();
        for (int i = 0; i < (nums1.length); i++) {
            int diff = nums1[i] - nums2[i];
            diffArr.add(diff);
        }
        ArrayList<Integer> dpPlus = new ArrayList<>();
        dpPlus.add(diffArr.get(0));
        ArrayList<Integer> dpMinus = new ArrayList<>();
        dpMinus.add(diffArr.get(0));

        for (int i = 1; i < diffArr.size(); i++) {
            dpPlus.add(Math.max(0, dpPlus.get(dpPlus.size()-1)) + diffArr.get(i));
            dpMinus.add(Math.min(0, dpMinus.get(dpMinus.size() - 1)) + diffArr.get(i));
        }
        // System.out.println("sum1 = " + sum1);
        // System.out.println("sum2 = " + sum2);
        // System.out.println("diffArr = " + diffArr.toString());
        // System.out.println("Plus = " + dpPlus.toString());
        // System.out.println("Minus = " + dpMinus.toString());

        if (diffArr.equals(dpPlus)  || diffArr.equals(dpMinus)) {
            return Math.max(sum1, sum2);
        }
        return Math.max(sum1 - Collections.min(dpMinus), sum2 + Collections.max(dpPlus));
    }
}