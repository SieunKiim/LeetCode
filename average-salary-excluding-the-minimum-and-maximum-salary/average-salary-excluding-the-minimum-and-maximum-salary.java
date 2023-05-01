class Solution {
    public double average(int[] salaries) {
        int big = Integer.MIN_VALUE;
        int small = Integer.MAX_VALUE;
        int total = 0;
        for(int salary : salaries){
            total += salary;
            big = Math.max(big, salary);
            small = Math.min(small, salary);
        }

        return (total- (big + small)+ 0.0)/(salaries.length-2);
    }
}