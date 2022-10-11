class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= small) { 
                small = n; 
            }
            else if (n <= big) { 
                big = n; 
            }
            else return true;
            // System.out.println(small+" "+big+" " + n);
        }
        return false;
    }
}