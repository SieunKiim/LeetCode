class Solution {
    public int numSteps(String s) {
        int l = s.length() - 1;
        int carry = 0;
        int count = 0;
        
        while (l > 0) {
            if (Character.getNumericValue(s.charAt(l)) + carry == 0) {
                carry = 0;
                count++;
            } else if (Character.getNumericValue(s.charAt(l)) + carry == 2) {
                carry = 1;
                count++;
            } else {
                carry = 1;
                count += 2;
            }
            l--;
        }
        if (carry == 1) {
            count++;
        }
        
        return count;
    }
}